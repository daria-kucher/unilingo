package diploma.unilingo.service.impl;

import diploma.unilingo.dto.LanguageLevelDTO;
import diploma.unilingo.entity.LanguageLevel;
import diploma.unilingo.exception.languageLevel.DuplicateLevelException;
import diploma.unilingo.exception.languageLevel.LanguageLevelNotFoundException;
import diploma.unilingo.mapper.LanguageLevelMapper;
import diploma.unilingo.repository.LanguageLevelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LanguageLevelServiceImplTest {
    @Mock
    private LanguageLevelRepository levelRepository;

    @Mock
    private LanguageLevelMapper levelMapper;

    @InjectMocks
    private LanguageLevelServiceImpl levelService;

    @Test
    void getAllLevels_Success() {
        LanguageLevel entity = new LanguageLevel();
        LanguageLevelDTO dto = new LanguageLevelDTO();

        when(levelRepository.findAll()).thenReturn(List.of(entity));
        when(levelMapper.toDto(entity)).thenReturn(dto);

        List<LanguageLevelDTO> result = levelService.getAllLevels();

        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
        verify(levelRepository).findAll();
    }

    @Test
    void getLevel_NotFound() {
        Long id = 1L;
        when(levelRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(LanguageLevelNotFoundException.class, () -> levelService.getLevel(id));
    }

    @Test
    void createLevel_DuplicateName() {
        LanguageLevelDTO dto = new LanguageLevelDTO();
        dto.setName("B2");
        when(levelRepository.existsByName("B2")).thenReturn(true);

        assertThrows(DuplicateLevelException.class, () -> levelService.createLevel(dto));
        verify(levelRepository, never()).save(any());
    }

    @Test
    void createLevel_Success() {
        LanguageLevelDTO dto = new LanguageLevelDTO();
        dto.setName("C1");
        LanguageLevel entity = new LanguageLevel();

        when(levelRepository.existsByName("C1")).thenReturn(false);
        when(levelMapper.toEntity(dto)).thenReturn(entity);
        when(levelMapper.toDto(entity)).thenReturn(dto);

         LanguageLevelDTO result = levelService.createLevel(dto);

        assertNotNull(result);
        verify(levelRepository).save(entity);
    }

    @Test
    void updateLevel_Success() {
        Long id = 1L;
        LanguageLevelDTO request = new LanguageLevelDTO();
        LanguageLevel existingEntity = new LanguageLevel();

        when(levelRepository.findById(id)).thenReturn(Optional.of(existingEntity));
        doNothing().when(levelMapper).update(request, existingEntity);
        when(levelMapper.toDto(existingEntity)).thenReturn(request);

        LanguageLevelDTO result = levelService.updateLevel(id, request);

        assertNotNull(result);
        verify(levelMapper).update(request, existingEntity);
        verify(levelRepository).save(existingEntity);
    }
}