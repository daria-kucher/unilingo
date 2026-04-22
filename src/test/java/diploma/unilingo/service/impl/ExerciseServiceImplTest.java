package diploma.unilingo.service.impl;

import diploma.unilingo.dto.ExerciseDTO;
import diploma.unilingo.dto.ExerciseResponseDTO;
import diploma.unilingo.entity.Exercise;
import diploma.unilingo.entity.SubSkill;
import diploma.unilingo.repository.ExerciseRepository;
import diploma.unilingo.repository.SubSkillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExerciseServiceImplTest {
    @Mock
    private ExerciseRepository exerciseRepository;

    @Mock
    private SubSkillRepository subSkillRepository;

    @InjectMocks
    private ExerciseServiceImpl exerciseService;

    private Exercise exercise;
    private SubSkill subSkill;

    @BeforeEach
    void setUp() {
        subSkill = new SubSkill();
        subSkill.setId(1L);
        subSkill.setName("Java Basics");

        exercise = new Exercise();
        exercise.setId(10L);
        exercise.setQuestion("2+2?");
        exercise.setCorrectAnswer("4");
        exercise.setWrongAnswers(List.of("3", "5"));
    }

    @Test
    void createExercise_Success() {
        // Arrange
        ExerciseDTO dto = new ExerciseDTO();
        dto.setQuestion("2+2?");
        dto.setCorrectAnswer("4");
        dto.setWrongAnswers(List.of("3", "5"));
        dto.setSubSkillIds(List.of(1L));

        when(subSkillRepository.findById(1L)).thenReturn(Optional.of(subSkill));
        when(exerciseRepository.save(any(Exercise.class))).thenAnswer(i -> i.getArguments()[0]);

        // Act
        Exercise result = exerciseService.createExercise(dto);

        // Assert
        assertNotNull(result);
        assertEquals("2+2?", result.getQuestion());
        assertEquals(1, result.getExerciseSubSkills().size());
        assertEquals(subSkill, result.getExerciseSubSkills().get(0).getSubSkill());

        verify(exerciseRepository, times(1)).save(any(Exercise.class));
        verify(subSkillRepository, times(1)).findById(1L);
    }

    @Test
    void getExercise_ShouldReturnMappedDTO() {
        // Arrange
        when(exerciseRepository.findById(10L)).thenReturn(Optional.of(exercise));

        // Act
        ExerciseResponseDTO response = exerciseService.getExercise(10L);

        // Assert
        assertNotNull(response);
        assertEquals(10L, response.getId());
        assertEquals("2+2?", response.getQuestion());
        assertEquals(3, response.getOptions().size());
        assertTrue(response.getOptions().contains("4"));
        assertTrue(response.getOptions().containsAll(List.of("3", "5")));

        verify(exerciseRepository, times(1)).findById(10L);
    }

    @Test
    void getExercise_ThrowsException_WhenNotFound() {
        // Arrange
        when(exerciseRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            exerciseService.getExercise(99L);
        });

        assertEquals("Exercise not found", exception.getMessage());
    }

    @Test
    void getExercisesBySubSkill_Success() {
        // Arrange
        when(subSkillRepository.findById(1L)).thenReturn(Optional.of(subSkill));
        when(exerciseRepository.findBySubSkills(subSkill)).thenReturn(List.of(exercise));

        // Act
        List<Exercise> results = exerciseService.getExercisesBySubSkill(1L);

        // Assert
        assertFalse(results.isEmpty());
        assertEquals(1, results.size());
        assertEquals("2+2?", results.get(0).getQuestion());

        verify(subSkillRepository).findById(1L);
        verify(exerciseRepository).findBySubSkills(subSkill);
    }
}