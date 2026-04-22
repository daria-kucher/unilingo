package diploma.unilingo.service;

import diploma.unilingo.dto.SkillProgressDTO;

import java.util.List;

public interface SkillService {
    List<SkillProgressDTO> getUserSkillProgress(Long userId);

    double getSkillProgress(Long userId, Long skillId);
}
