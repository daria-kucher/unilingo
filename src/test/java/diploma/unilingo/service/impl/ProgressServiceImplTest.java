package diploma.unilingo.service.impl;

import diploma.unilingo.dto.WeeklyProgressDTO;
import diploma.unilingo.entity.WeeklyProgress;
import diploma.unilingo.exception.weeklyprogress.ProgressNotFoundException;
import diploma.unilingo.mapper.ProgressMapper;
import diploma.unilingo.repository.ProgressRepository;
import org.junit.jupiter.api.BeforeEach;
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
class ProgressServiceImplTest {
    @Mock
    private ProgressRepository progressRepository;

    @Mock
    private ProgressMapper progressMapper;

    @InjectMocks
    private ProgressServiceImpl progressService;

    private WeeklyProgress entity;
    private WeeklyProgressDTO dto;
    private final Long progressId = 1L;
    private final Long userId = 50L;

    @BeforeEach
    void setUp() {
        entity = new WeeklyProgress();
        dto = new WeeklyProgressDTO();
    }


    @Test
    void getProgress_ShouldReturnDto_WhenIdExists() {
        when(progressRepository.findById(progressId)).thenReturn(Optional.of(entity));
        when(progressMapper.toDto(entity)).thenReturn(dto);

        WeeklyProgressDTO result = progressService.getProgress(progressId);

        assertNotNull(result);
        verify(progressRepository).findById(progressId);
    }

    @Test
    void getProgress_ShouldThrowException_WhenIdNotFound() {
        when(progressRepository.findById(progressId)).thenReturn(Optional.empty());

        assertThrows(ProgressNotFoundException.class, () -> progressService.getProgress(progressId));
        verifyNoInteractions(progressMapper);
    }


    @Test
    void getProgressesByUserId_ShouldReturnList() {
        List<WeeklyProgress> entities = List.of(entity, new WeeklyProgress());
        when(progressRepository.findAllByUserId(userId)).thenReturn(entities);
        when(progressMapper.toDto(any(WeeklyProgress.class))).thenReturn(new WeeklyProgressDTO());

        List<WeeklyProgressDTO> results = progressService.getProgressesByUserId(userId);

        assertEquals(2, results.size());
        verify(progressRepository).findAllByUserId(userId);
        verify(progressMapper, times(2)).toDto(any(WeeklyProgress.class));
    }


    @Test
    void createProgress_ShouldSaveAndReturnDto() {
        when(progressMapper.toEntity(dto)).thenReturn(entity);
        when(progressRepository.save(entity)).thenReturn(entity);
        when(progressMapper.toDto(entity)).thenReturn(dto);

        WeeklyProgressDTO result = progressService.createProgress(dto);

        assertNotNull(result);
        verify(progressMapper).toEntity(dto);
        verify(progressRepository).save(entity);
        verify(progressMapper).toDto(entity);
    }
}