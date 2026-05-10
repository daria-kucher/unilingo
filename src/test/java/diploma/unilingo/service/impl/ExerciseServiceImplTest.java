package diploma.unilingo.service.impl;

import diploma.unilingo.dto.ExerciseDTO;
import diploma.unilingo.entity.Exercise;
import diploma.unilingo.exception.exercise.ExerciseNotFoundException;
import diploma.unilingo.mapper.ExerciseMapper;
import diploma.unilingo.repository.ExerciseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExerciseServiceImplTest {

    @Mock
    private ExerciseRepository exerciseRepository;

    @Mock
    private ExerciseMapper exerciseMapper;

    @InjectMocks
    private ExerciseServiceImpl exerciseService;

    @Test
    void getExercise_ValidId_ReturnsDto() {
        Long id = 1L;
        Exercise exercise = new Exercise();
        ExerciseDTO expectedDto = new ExerciseDTO();

        when(exerciseRepository.findById(id)).thenReturn(Optional.of(exercise));
        when(exerciseMapper.toDto(exercise)).thenReturn(expectedDto);

        ExerciseDTO result = exerciseService.getExercise(id);

        assertNotNull(result);
        assertEquals(expectedDto, result);
        verify(exerciseRepository).findById(id);
    }

    @Test
    void getExercise_InvalidId_ThrowsException() {
        Long id = 1L;
        when(exerciseRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ExerciseNotFoundException.class, () -> exerciseService.getExercise(id));
    }

    @Test
    void createExercise_ValidDto_ReturnsSavedDto() {
        ExerciseDTO inputDto = new ExerciseDTO();
        Exercise exercise = new Exercise();
        ExerciseDTO outputDto = new ExerciseDTO();

        when(exerciseMapper.toEntity(inputDto)).thenReturn(exercise);
        when(exerciseMapper.toDto(exercise)).thenReturn(outputDto);

        ExerciseDTO result = exerciseService.createExercise(inputDto);

        assertNotNull(result);
        verify(exerciseRepository).save(exercise);
    }

    @Test
    void updateExercise_ExistingId_UpdatesAndReturnsDto() {
        Long id = 1L;
        ExerciseDTO requestDto = new ExerciseDTO();
        Exercise existingExercise = new Exercise();
        ExerciseDTO responseDto = new ExerciseDTO();

        when(exerciseRepository.findById(id)).thenReturn(Optional.of(existingExercise));
        when(exerciseMapper.toDto(existingExercise)).thenReturn(responseDto);

        ExerciseDTO result = exerciseService.updateExercise(id, requestDto);

        verify(exerciseMapper).update(requestDto, existingExercise);
        verify(exerciseRepository).save(existingExercise);
        assertNotNull(result);
    }

    @Test
    void delete_ExistingId_DeletesExercise() {
        Long id = 1L;
        Exercise exercise = new Exercise();
        when(exerciseRepository.findById(id)).thenReturn(Optional.of(exercise));

        exerciseService.delete(id);

        verify(exerciseRepository).delete(exercise);
    }
}