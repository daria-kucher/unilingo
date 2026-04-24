package diploma.unilingo.service.impl;

import diploma.unilingo.dto.AttemptRequestDTO;
import diploma.unilingo.dto.AttemptResponseDTO;
import diploma.unilingo.entity.*;
import diploma.unilingo.repository.AttemptRepository;
import diploma.unilingo.repository.ExerciseRepository;
import diploma.unilingo.repository.UserRepository;
import diploma.unilingo.repository.UserSubSkillRepository;
import diploma.unilingo.service.BKTService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AttemptServiceImplTest {

    @Mock private AttemptRepository attemptRepository;
    @Mock private UserRepository userRepository;
    @Mock private ExerciseRepository exerciseRepository;
    @Mock private BKTService bktService;
    @Mock private UserSubSkillRepository userSubSkillRepository;

    @InjectMocks
    private AttemptServiceImpl attemptService;

    private User user;
    private Exercise exercise;
    private AttemptRequestDTO request;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);

        exercise = new Exercise();
        exercise.setId(10L);
        exercise.setCorrectAnswer("Paris");

        request = new AttemptRequestDTO();
        request.setUserId(1L);
        request.setExerciseId(10L);
        request.setAnswer("Paris");
        request.setTimeSpent(30);
    }

    @Test
    void submitAttempt_Success_CorrectAnswer() {
        // Arrange
        SubSkill subSkill = new SubSkill();
        ExerciseSubSkill link = new ExerciseSubSkill();
        link.setSubSkill(subSkill);
        link.setWeight(0.5);
        exercise.setExerciseSubSkills(Collections.singletonList(link));

        UserSubSkill userSubSkill = new UserSubSkill();
        userSubSkill.setpKnowledge(0.4);
        userSubSkill.setWeeklyScore(0.0);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(exerciseRepository.findById(10L)).thenReturn(Optional.of(exercise));
        when(userSubSkillRepository.findByUserAndSubSkill(user, subSkill)).thenReturn(Optional.of(userSubSkill));
        when(bktService.updateKnowledge(0.4, true, 0.5)).thenReturn(0.6);

        // Act
        AttemptResponseDTO response = attemptService.submitAttempt(request);

        // Assert
        assertTrue(response.isCorrect());
        assertEquals("Paris", response.getCorrectAnswer());
        assertEquals(0.6, userSubSkill.getpKnowledge());
        assertEquals(5.0, userSubSkill.getWeeklyScore()); // weight 0.5 * 10

        verify(attemptRepository, times(1)).save(any(Attempt.class));
        verify(userSubSkillRepository, times(1)).save(userSubSkill);
    }

    @Test
    void submitAttempt_Success_WrongAnswer() {
        // Arrange
        request.setAnswer("London"); // Wrong answer
        exercise.setExerciseSubSkills(Collections.emptyList());

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(exerciseRepository.findById(10L)).thenReturn(Optional.of(exercise));

        // Act
        AttemptResponseDTO response = attemptService.submitAttempt(request);

        // Assert
        assertFalse(response.isCorrect());
        assertEquals("Paris", response.getCorrectAnswer());
        verify(attemptRepository).save(argThat(attempt -> !attempt.isCorrect()));
    }

    @Test
    void submitAttempt_UserNotFound_ThrowsException() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> attemptService.submitAttempt(request));
        verifyNoInteractions(attemptRepository, bktService);
    }

    @Test
    void submitAttempt_SubSkillNotFound_ThrowsException() {
        // Arrange
        ExerciseSubSkill link = new ExerciseSubSkill();
        link.setSubSkill(new SubSkill());
        exercise.setExerciseSubSkills(Collections.singletonList(link));

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(exerciseRepository.findById(10L)).thenReturn(Optional.of(exercise));
        when(userSubSkillRepository.findByUserAndSubSkill(any(), any())).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> attemptService.submitAttempt(request));

        assertEquals("UserSubSkill not found", exception.getMessage());
    }
}