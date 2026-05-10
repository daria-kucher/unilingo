package diploma.unilingo.service.impl;

import diploma.unilingo.dto.SubSkillProfileDTO;
import diploma.unilingo.entity.SubSkill;
import diploma.unilingo.entity.SubSkillProfile;
import diploma.unilingo.exception.subskillProfile.SubSkillProfileNotFoundException;
import diploma.unilingo.mapper.SubSkillProfileMapper;
import diploma.unilingo.repository.SubSkillProfileRepository;
import diploma.unilingo.service.SubSkillService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SubSkillProfileServiceImplTest {

    @Mock
    private SubSkillProfileRepository profileRepository;

    @Mock
    private SubSkillProfileMapper profileMapper;

    @Mock
    private SubSkillService subSkillService;

    @InjectMocks
    private SubSkillProfileServiceImpl profileService;

    private SubSkillProfile profile;
    private SubSkillProfileDTO profileDTO;

    @BeforeEach
    void setUp() {
        profile = new SubSkillProfile();
        profileDTO = new SubSkillProfileDTO();
        profileDTO.setId(1L);
    }

    @Test
    void getProfile_ShouldReturnDto_WhenIdExists() {
        when(profileRepository.findById(1L)).thenReturn(Optional.of(profile));
        when(profileMapper.toDto(profile)).thenReturn(profileDTO);

        SubSkillProfileDTO result = profileService.getProfile(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(profileRepository).findById(1L);
    }

    @Test
    void getProfile_ShouldThrowException_WhenIdDoesNotExist() {
        when(profileRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(SubSkillProfileNotFoundException.class, () -> profileService.getProfile(1L));
    }

    @Test
    void createProfile_ShouldCreateAllSubSkillsAndSave() {
        when(subSkillService.createSubSkill(anyString(), any())).thenReturn(new SubSkill());
        when(profileMapper.toDto(any(SubSkillProfile.class))).thenReturn(profileDTO);

        SubSkillProfileDTO result = profileService.createProfile(new SubSkillProfileDTO());

        assertNotNull(result);
        verify(subSkillService, times(8)).createSubSkill(anyString(), any());
        verify(profileRepository).save(any(SubSkillProfile.class));
    }

    @Test
    void updateProfile_ShouldUpdateAndSave_WhenExists() {
        when(profileRepository.findById(1L)).thenReturn(Optional.of(profile));
        when(profileMapper.toDto(profile)).thenReturn(profileDTO);

        SubSkillProfileDTO result = profileService.updateProfile(1L, profileDTO);

        verify(profileMapper).update(profileDTO, profile);
        verify(profileRepository).save(profile);
        assertNotNull(result);
    }

    @Test
    void addProfile_ShouldInvokeAddPointsForAllSubSkills() {
        SubSkillProfile target = new SubSkillProfile();
        SubSkillProfile source = new SubSkillProfile();

        target.setConversationManagement(new SubSkill());
        source.setConversationManagement(new SubSkill());

        when(profileRepository.findById(1L)).thenReturn(Optional.of(target));
        when(profileRepository.findById(2L)).thenReturn(Optional.of(source));
        when(profileMapper.toDto(target)).thenReturn(profileDTO);

        SubSkillProfileDTO targetDto = new SubSkillProfileDTO();
        targetDto.setId(1L);
        SubSkillProfileDTO sourceDto = new SubSkillProfileDTO();
        sourceDto.setId(2L);

        profileService.addProfile(targetDto, sourceDto);

        verify(subSkillService, times(8)).addPoints(any(), any());
        verify(profileRepository).save(target);
    }
}