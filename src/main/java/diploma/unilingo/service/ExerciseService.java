package diploma.unilingo.service;

import diploma.unilingo.dto.ExerciseDTO;
import diploma.unilingo.dto.ExerciseResponseDTO;
import diploma.unilingo.entity.Exercise;

import java.util.List;

public interface ExerciseService {
    Exercise createExercise(ExerciseDTO dto);

    ExerciseResponseDTO getExercise(Long id);

    List<Exercise> getExercisesBySubSkill(Long subSkillId);
}
