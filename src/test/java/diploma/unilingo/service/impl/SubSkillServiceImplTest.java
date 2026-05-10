package diploma.unilingo.service.impl;

import diploma.unilingo.dto.SubSkillDTO;
import diploma.unilingo.entity.SubSkill;
import diploma.unilingo.exception.subskill.SubSkillNotFoundException;
import diploma.unilingo.mapper.SubSkillMapper;
import diploma.unilingo.repository.SubSkillRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SubSkillServiceImplTest {

    @Mock
    private SubSkillRepository subSkillRepository;

    @Mock
    private SubSkillMapper subSkillMapper;

    @InjectMocks
    private SubSkillServiceImpl subSkillService;

    @Test
    void getSubSkill_Success() {
        Long id = 1L;
        SubSkill entity = new SubSkill();
        SubSkillDTO expectedDto = new SubSkillDTO();

        when(subSkillRepository.findSubSkillById(id)).thenReturn(Optional.of(entity));
        when(subSkillMapper.toDto(entity)).thenReturn(expectedDto);

        SubSkillDTO result = subSkillService.getSubSkill(id);

        assertNotNull(result);
        assertEquals(expectedDto, result);
        verify(subSkillRepository).findSubSkillById(id);
    }

    @Test
    void getSubSkill_NotFound() {
        Long id = 99L;
        when(subSkillRepository.findSubSkillById(id)).thenReturn(Optional.empty());

        assertThrows(SubSkillNotFoundException.class, () -> subSkillService.getSubSkill(id));
    }

    /*
    @Test
    void createSubSkill_Success() {
        SubSkillDTO inputDto = new SubSkillDTO();
        SubSkill entity = new SubSkill();

        when(subSkillMapper.toEntity(inputDto)).thenReturn(entity);
        when(subSkillRepository.save(entity)).thenReturn(entity);
        when(subSkillMapper.toDto(entity)).thenReturn(inputDto);

        SubSkillDTO result = subSkillService.createSubSkill(inputDto);

        assertNotNull(result);
        verify(subSkillRepository, times(1)).save(entity);
    } */

    @Test
     void updateSubSkill_Success() {
        Long id = 1L;
        SubSkillDTO requestDto = new SubSkillDTO();
        SubSkill existingEntity = new SubSkill();

        when(subSkillRepository.findSubSkillById(id)).thenReturn(Optional.of(existingEntity));
        doNothing().when(subSkillMapper).update(requestDto, existingEntity);
        when(subSkillRepository.save(existingEntity)).thenReturn(existingEntity);
        when(subSkillMapper.toDto(existingEntity)).thenReturn(requestDto);

        SubSkillDTO result = subSkillService.updateSubSkill(id, requestDto);

        assertNotNull(result);
        verify(subSkillMapper).update(requestDto, existingEntity);
        verify(subSkillRepository).save(existingEntity);
    }
}