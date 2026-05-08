package diploma.unilingo.service;

import diploma.unilingo.dto.GoalDTO;
import diploma.unilingo.entity.Goal;

public interface GoalService {
    GoalDTO createGoal(GoalDTO request);

    GoalDTO getGoal(Long id);
}
