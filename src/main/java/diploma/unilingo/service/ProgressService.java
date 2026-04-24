package diploma.unilingo.service;

import diploma.unilingo.dto.ProgressDTO;

public interface ProgressService {
    ProgressDTO getUserProgress(Long userId);
}
