package diploma.unilingo.service;

import diploma.unilingo.dto.ExerciseResponseDTO;

public interface AdaptiveService {
    ExerciseResponseDTO getNextExercise(Long userId);

    Module getNextModule(Long userId);
}
