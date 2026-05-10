package diploma.unilingo.service;

import diploma.unilingo.dto.ExerciseDTO;

public interface ExerciseService {
    ExerciseDTO getExercise(Long id);
    ExerciseDTO createExercise(ExerciseDTO dto);
    ExerciseDTO updateExercise(Long id, ExerciseDTO request);
    void delete(Long id);
}
