package diploma.unilingo.service.impl;

import diploma.unilingo.dto.AttemptRequestDTO;
import diploma.unilingo.dto.AttemptResponseDTO;
import diploma.unilingo.entity.*;
import diploma.unilingo.repository.AttemptRepository;
import diploma.unilingo.repository.ExerciseRepository;
import diploma.unilingo.repository.UserRepository;
import diploma.unilingo.repository.UserSubSkillRepository;
import diploma.unilingo.service.AttemptService;
import diploma.unilingo.service.BKTService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AttemptServiceImpl implements AttemptService {
    private final AttemptRepository attemptRepository;
    private final UserRepository userRepository;
    private final ExerciseRepository exerciseRepository;
    private final BKTService bktService;
    private final UserSubSkillRepository userSubSkillRepository;

    public AttemptServiceImpl(AttemptRepository attemptRepository,
                              UserRepository userRepository,
                              ExerciseRepository exerciseRepository, BKTService bktService, UserSubSkillRepository userSubSkillRepository) {
        this.attemptRepository = attemptRepository;
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
        this.bktService = bktService;
        this.userSubSkillRepository = userSubSkillRepository;
    }

    @Override
    public AttemptResponseDTO submitAttempt(AttemptRequestDTO request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Exercise exercise = exerciseRepository.findById(request.getExerciseId())
                .orElseThrow(() -> new RuntimeException("Exercise not found"));

        boolean isCorrect = exercise.getCorrectAnswer()
                .equalsIgnoreCase(request.getAnswer());

        // зберігаємо Attempt
        Attempt attempt = new Attempt();
        attempt.setUser(user);
        attempt.setExercise(exercise);
        attempt.setCorrect(isCorrect);
        attempt.setTimeSpent(request.getTimeSpent());
        attempt.setTimestamp(LocalDateTime.now());

        attemptRepository.save(attempt);

        // ================= BKT ЛОГІКА =================

        for (ExerciseSubSkill link : exercise.getExerciseSubSkills()) {

            SubSkill subSkill = link.getSubSkill();
            double weight = link.getWeight();

            UserSubSkill userSubSkill =
                    userSubSkillRepository.findByUserAndSubSkill(user, subSkill)
                            .orElseThrow(() -> new RuntimeException("UserSubSkill not found"));

            double prior = userSubSkill.getpKnowledge();

            double updated = bktService.updateKnowledge(prior, isCorrect, weight);

            userSubSkill.setpKnowledge(updated);

            // додаємо до weekly progress
            if (isCorrect) {
                userSubSkill.setWeeklyScore(
                        userSubSkill.getWeeklyScore() + weight * 10
                );
            }

            userSubSkillRepository.save(userSubSkill);
        }

        // ================= RESPONSE =================

        AttemptResponseDTO response = new AttemptResponseDTO();
        response.setCorrect(isCorrect);
        response.setCorrectAnswer(exercise.getCorrectAnswer());

        return response;
    }
}
