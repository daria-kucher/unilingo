package diploma.unilingo.service;

import diploma.unilingo.entity.Module;

public interface AdaptiveService {
    ExerciseResponseDTO getNextExercise(Long userId);

    Module getNextModule(Long userId);
}
