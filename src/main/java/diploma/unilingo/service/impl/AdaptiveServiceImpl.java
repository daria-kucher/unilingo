package diploma.unilingo.service.impl;

import diploma.unilingo.dto.ExerciseResponseDTO;
import diploma.unilingo.entity.*;
import diploma.unilingo.entity.Module;
import diploma.unilingo.repository.ExerciseRepository;
import diploma.unilingo.repository.ModuleRepository;
import diploma.unilingo.repository.UserRepository;
import diploma.unilingo.repository.UserSubSkillRepository;
import diploma.unilingo.service.AdaptiveService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdaptiveServiceImpl implements AdaptiveService {
    private final UserRepository userRepository;
    private final UserSubSkillRepository userSubSkillRepository;
    private final ExerciseRepository exerciseRepository;
    private final ModuleRepository moduleRepository;

    public AdaptiveServiceImpl(UserRepository userRepository,
                               UserSubSkillRepository userSubSkillRepository,
                               ExerciseRepository exerciseRepository,
                               ModuleRepository moduleRepository) {
        this.userRepository = userRepository;
        this.userSubSkillRepository = userSubSkillRepository;
        this.exerciseRepository = exerciseRepository;
        this.moduleRepository = moduleRepository;
    }

    // ================= EXERCISE =================

    @Override
    public ExerciseResponseDTO getNextExercise(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserSubSkill weakest = userSubSkillRepository.findByUser(user)
                .stream()
                .min(Comparator.comparingDouble(UserSubSkill::getpKnowledge))
                .orElseThrow();

        SubSkill target = weakest.getSubSkill();

        List<Exercise> exercises = exerciseRepository.findBySubSkills(target);

        if (exercises.isEmpty()) {
            throw new RuntimeException("No exercises found");
        }

        Exercise exercise = exercises.get(0);

        List<String> options = new ArrayList<>();
        options.add(exercise.getCorrectAnswer());
        options.addAll(exercise.getWrongAnswers());
        Collections.shuffle(options);

        ExerciseResponseDTO dto = new ExerciseResponseDTO();
        dto.setId(exercise.getId());
        dto.setQuestion(exercise.getQuestion());
        dto.setOptions(options);

        return dto;
    }

    // ================= MODULE 🔥 =================

    @Override
    public Module getNextModule(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🔥 1. знайти найслабшу Skill
        Skill weakestSkill = userSubSkillRepository.findByUser(user)
                .stream()
                .collect(Collectors.groupingBy(
                        us -> us.getSubSkill().getSkill(),
                        Collectors.averagingDouble(UserSubSkill::getpKnowledge)
                ))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();

        // 🔥 2. знайти модулі для цієї навички
        List<diploma.unilingo.entity.Module> modules = moduleRepository.findBySkills(weakestSkill);

        if (modules.isEmpty()) {
            throw new RuntimeException("No modules for skill");
        }

        // 🔥 3. (MVP) просто повертаємо перший
        return modules.get(0);
    }
}
