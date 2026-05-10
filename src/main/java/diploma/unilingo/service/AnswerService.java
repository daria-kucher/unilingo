package diploma.unilingo.service;

import diploma.unilingo.dto.AnswerDTO;

import java.util.List;

public interface AnswerService {
    AnswerDTO getAnswer(Long id);
    List<AnswerDTO> getAllAnswers(Long idExercise);
    AnswerDTO createAnswer(AnswerDTO dto);
    AnswerDTO updateAnswer(Long id, AnswerDTO request);
    void deleteAnswer(Long id);
}
