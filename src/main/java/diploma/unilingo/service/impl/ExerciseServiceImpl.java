package diploma.unilingo.service.impl;

import diploma.unilingo.dto.ExerciseDTO;
import diploma.unilingo.dto.ExerciseResponseDTO;
import diploma.unilingo.entity.Exercise;
import diploma.unilingo.entity.ExerciseSubSkill;
import diploma.unilingo.entity.SubSkill;
import diploma.unilingo.repository.ExerciseRepository;
import diploma.unilingo.repository.SubSkillRepository;
import diploma.unilingo.service.ExerciseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final SubSkillRepository subSkillRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository,
                               SubSkillRepository subSkillRepository) {
        this.exerciseRepository = exerciseRepository;
        this.subSkillRepository = subSkillRepository;
    }

    // ================= CREATE =================

    @Override
    public Exercise createExercise(ExerciseDTO dto) {

        Exercise exercise = new Exercise();
        exercise.setQuestion(dto.getQuestion());
        exercise.setCorrectAnswer(dto.getCorrectAnswer());
        exercise.setWrongAnswers(dto.getWrongAnswers());

        List<ExerciseSubSkill> links = new ArrayList<>();

        for (Long subSkillId : dto.getSubSkillIds()) {

            SubSkill subSkill = subSkillRepository.findById(subSkillId)
                    .orElseThrow();

            ExerciseSubSkill link = new ExerciseSubSkill();
            link.setExercise(exercise);
            link.setSubSkill(subSkill);
            link.setWeight(1.0); // або різна вага

            links.add(link);
        }

        exercise.setExerciseSubSkills(links);

        return exerciseRepository.save(exercise);
    }

    // ================= GET ONE =================

    @Override
    @Transactional(readOnly = true)
    public ExerciseResponseDTO getExercise(Long id) {

        Exercise exercise = exerciseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercise not found"));

        return mapToResponseDTO(exercise);
    }

    // ================= GET BY SUBSKILL =================

    @Override
    @Transactional(readOnly = true)
    public List<Exercise> getExercisesBySubSkill(Long subSkillId) {

        SubSkill subSkill = subSkillRepository.findById(subSkillId)
                .orElseThrow(() -> new RuntimeException("SubSkill not found"));

        return exerciseRepository.findBySubSkills(subSkill);
    }

    // ================= MAPPER =================

    private ExerciseResponseDTO mapToResponseDTO(Exercise exercise) {

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
}
