package diploma.unilingo.service;

import diploma.unilingo.dto.GoalDTO;
import diploma.unilingo.entity.Goal;

public interface GoalService {
    Goal createOrUpdateGoal(Long userId, GoalDTO dto);

    Goal getUserGoal(Long userId);

    double calculateProgress(Long userId);
}
