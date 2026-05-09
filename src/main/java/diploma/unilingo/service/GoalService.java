package diploma.unilingo.service;

import diploma.unilingo.dto.GoalDTO;

public interface GoalService {
    GoalDTO createGoal(GoalDTO request);

    GoalDTO getGoal(Long id);
}
