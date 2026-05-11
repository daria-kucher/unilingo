package diploma.unilingo.service;

import diploma.unilingo.dto.WeeklyProgressDTO;

import java.util.List;

public interface ProgressService {
    WeeklyProgressDTO getProgress(Long id);
    List<WeeklyProgressDTO> getProgressesByUserId(Long userId);
    WeeklyProgressDTO createProgress(WeeklyProgressDTO dto);
}
