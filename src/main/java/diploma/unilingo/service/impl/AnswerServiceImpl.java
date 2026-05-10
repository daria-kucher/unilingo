package diploma.unilingo.service.impl;

import diploma.unilingo.dto.AnswerDTO;
import diploma.unilingo.exception.answer.AnswerNotFoundException;
import diploma.unilingo.exception.answer.DuplicateAnswerException;
import diploma.unilingo.mapper.AnswerMapper;
import diploma.unilingo.repository.AnswerRepository;
import diploma.unilingo.service.AnswerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    public AnswerServiceImpl(AnswerRepository answerRepository, AnswerMapper answerMapper) {
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
    }


    @Override
    public AnswerDTO getAnswer(Long id) {
        var answer = answerRepository.findById(id).orElseThrow(AnswerNotFoundException::new);

        return answerMapper.toDto(answer);
    }

    @Override
    public List<AnswerDTO> getAllAnswers(Long idExercise) {
        return answerRepository.findByExerciseId(idExercise)
                .stream()
                .map(answerMapper::toDto)
                .toList();
    }

    @Override
    public AnswerDTO createAnswer(AnswerDTO dto) {
        boolean exists = answerRepository
                .existsByExerciseIdAndText(
                        dto.getExerciseId(),
                        dto.getText()
                );

        if (exists)
            throw new DuplicateAnswerException();

        var answer = answerMapper.toEntity(dto);
        answerRepository.save(answer);

        return answerMapper.toDto(answer);
    }

    @Override
    public AnswerDTO updateAnswer(Long id, AnswerDTO request) {
        var answer = answerRepository.findById(id).orElseThrow(AnswerNotFoundException::new);

        answerMapper.update(request, answer);
        answerRepository.save(answer);

        return answerMapper.toDto(answer);
    }

    @Override
    public void deleteAnswer(Long id) {
        var answer = answerRepository.findById(id).orElseThrow(AnswerNotFoundException::new);

        answerRepository.delete(answer);
    }
}
