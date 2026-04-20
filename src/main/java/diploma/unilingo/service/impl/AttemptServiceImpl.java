package diploma.unilingo.service.impl;

import diploma.unilingo.dto.AttemptRequestDTO;
import diploma.unilingo.dto.AttemptResponseDTO;
import diploma.unilingo.entity.Attempt;
import diploma.unilingo.entity.Exercise;
import diploma.unilingo.entity.User;
import diploma.unilingo.repository.AttemptRepository;
import diploma.unilingo.repository.ExerciseRepository;
import diploma.unilingo.repository.UserRepository;
import diploma.unilingo.service.AttemptService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AttemptServiceImpl implements AttemptService {
    private final AttemptRepository attemptRepository;
    private final UserRepository userRepository;
    private final ExerciseRepository exerciseRepository;

    public AttemptServiceImpl(AttemptRepository attemptRepository,
                              UserRepository userRepository,
                              ExerciseRepository exerciseRepository) {
        this.attemptRepository = attemptRepository;
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public AttemptResponseDTO submitAttempt(AttemptRequestDTO request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Exercise exercise = exerciseRepository.findById(request.getExerciseId())
                .orElseThrow(() -> new RuntimeException("Exercise not found"));

        boolean isCorrect = exercise.getCorrectAnswer()
                .equalsIgnoreCase(request.getAnswer());

        Attempt attempt = new Attempt();
        attempt.setUser(user);
        attempt.setExercise(exercise);
        attempt.setCorrect(isCorrect);
        attempt.setTimeSpent(request.getTimeSpent());
        attempt.setTimestamp(LocalDateTime.now());

        attemptRepository.save(attempt);

        // bktService.update(...)

        AttemptResponseDTO response = new AttemptResponseDTO();
        response.setCorrect(isCorrect);
        response.setCorrectAnswer(exercise.getCorrectAnswer());

        return response;
    }
}
