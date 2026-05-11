package diploma.unilingo.service.impl;

import diploma.unilingo.dto.AttemptDTO;
import diploma.unilingo.entity.Attempt;
import diploma.unilingo.exception.attempt.AttemptNotFoundException;
import diploma.unilingo.mapper.AttemptMapper;
import diploma.unilingo.repository.AttemptRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AttemptServiceImplTest {
    @Mock
    private AttemptRepository attemptRepository;

    @Mock
    private AttemptMapper attemptMapper;

    @InjectMocks
    private AttemptServiceImpl attemptService;

    private Attempt entity;
    private AttemptDTO dto;
    private final Long attemptId = 1L;

    @BeforeEach
    void setUp() {
        entity = new Attempt();
        dto = new AttemptDTO();
    }


    @Test
    void getAttempt_ShouldReturnDto_WhenIdExists() {
        when(attemptRepository.findById(attemptId)).thenReturn(Optional.of(entity));
        when(attemptMapper.toDto(entity)).thenReturn(dto);

        AttemptDTO result = attemptService.getAttempt(attemptId);

        assertNotNull(result);
        verify(attemptRepository).findById(attemptId);
        verify(attemptMapper).toDto(entity);
    }

    @Test
    void getAttempt_ShouldThrowException_WhenIdNotFound() {
        when(attemptRepository.findById(attemptId)).thenReturn(Optional.empty());

        assertThrows(AttemptNotFoundException.class, () -> attemptService.getAttempt(attemptId));
        verifyNoInteractions(attemptMapper);
    }


    @Test
    void createAttempt_ShouldSaveAndReturnDto() {
        when(attemptMapper.toEntity(dto)).thenReturn(entity);
        when(attemptRepository.save(entity)).thenReturn(entity);
        when(attemptMapper.toDto(entity)).thenReturn(dto);

        AttemptDTO result = attemptService.createAttempt(dto);

        assertNotNull(result);
        verify(attemptMapper).toEntity(dto);
        verify(attemptRepository).save(entity);
        verify(attemptMapper).toDto(entity);
    }
}