package diploma.unilingo.service;

import diploma.unilingo.dto.AttemptRequestDTO;
import diploma.unilingo.dto.AttemptResponseDTO;

public interface AttemptService {
    AttemptResponseDTO submitAttempt(AttemptRequestDTO request);
}
