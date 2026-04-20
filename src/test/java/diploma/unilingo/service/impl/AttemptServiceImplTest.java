package diploma.unilingo.service.impl;

import diploma.unilingo.dto.AttemptRequestDTO;
import diploma.unilingo.dto.AttemptResponseDTO;
import diploma.unilingo.entity.Exercise;
import diploma.unilingo.entity.User;
import diploma.unilingo.repository.AttemptRepository;
import diploma.unilingo.repository.ExerciseRepository;
import diploma.unilingo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AttemptServiceImplTest {

    @Mock
    private AttemptRepository attemptRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ExerciseRepository exerciseRepository;

    @InjectMocks
    private AttemptServiceImpl attemptService;

    @Test
    void shouldReturnCorrectTrueWhenAnswerMatches() {

        User user = new User();
        user.setId(1L);

        Exercise exercise = new Exercise();
        exercise.setId(1L);
        exercise.setCorrectAnswer("hello");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(exerciseRepository.findById(1L)).thenReturn(Optional.of(exercise));

        AttemptRequestDTO request = new AttemptRequestDTO();
        request.setUserId(1L);
        request.setExerciseId(1L);
        request.setAnswer("hello");
        request.setTimeSpent(5);

        AttemptResponseDTO response = attemptService.submitAttempt(request);

        assertTrue(response.isCorrect());
    }
}