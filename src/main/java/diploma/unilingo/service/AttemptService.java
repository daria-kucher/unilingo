package diploma.unilingo.service;

import diploma.unilingo.dto.AttemptDTO;

public interface AttemptService {
    AttemptDTO getAttempt(Long id);
    AttemptDTO createAttempt(AttemptDTO dto);
}
