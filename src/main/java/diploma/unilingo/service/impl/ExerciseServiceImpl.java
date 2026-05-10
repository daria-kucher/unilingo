package diploma.unilingo.service.impl;

import diploma.unilingo.dto.ExerciseDTO;
import diploma.unilingo.exception.exercise.ExerciseNotFoundException;
import diploma.unilingo.mapper.ExerciseMapper;
import diploma.unilingo.repository.ExerciseRepository;
import diploma.unilingo.service.ExerciseService;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ExerciseMapper exerciseMapper) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseMapper = exerciseMapper;
    }


    @Override
    public ExerciseDTO getExercise(Long id) {
        var exercise = exerciseRepository.findById(id).orElseThrow(ExerciseNotFoundException::new);

        return exerciseMapper.toDto(exercise);
    }

    @Override
    public ExerciseDTO createExercise(ExerciseDTO dto) {
        var exercise = exerciseMapper.toEntity(dto);
        exerciseRepository.save(exercise);

        return exerciseMapper.toDto(exercise);
    }

    @Override
    public ExerciseDTO updateExercise(Long id, ExerciseDTO request) {
        var exercise = exerciseRepository.findById(id).orElseThrow(ExerciseNotFoundException::new);

        exerciseMapper.update(request, exercise);
        exerciseRepository.save(exercise);

        return exerciseMapper.toDto(exercise);
    }

    @Override
    public void delete(Long id) {
        var exercise = exerciseRepository.findById(id).orElseThrow(ExerciseNotFoundException::new);

        exerciseRepository.delete(exercise);
    }
}
