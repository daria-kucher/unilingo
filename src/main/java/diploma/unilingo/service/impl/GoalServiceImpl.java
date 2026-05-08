package diploma.unilingo.service.impl;

import diploma.unilingo.dto.GoalDTO;
import diploma.unilingo.entity.Goal;
import diploma.unilingo.entity.User;
import diploma.unilingo.entity.UserSubSkill;
import diploma.unilingo.exception.goal.GoalNotFoundException;
import diploma.unilingo.mapper.GoalMapper;
import diploma.unilingo.repository.GoalRepository;
import diploma.unilingo.repository.UserRepository;
import diploma.unilingo.repository.UserSubSkillRepository;
import diploma.unilingo.service.GoalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {
    private final GoalRepository goalRepository;
    private final GoalMapper goalMapper;

    public GoalServiceImpl(GoalRepository goalRepository, GoalMapper goalMapper) {
        this.goalRepository = goalRepository;
        this.goalMapper = goalMapper;
    }

    @Override
    public GoalDTO createGoal(GoalDTO request) {
        var goal = goalMapper.toEntity(request);
        goalRepository.save(goal);

        return goalMapper.toDto(goal);
    }

    @Override
    public GoalDTO getGoal(Long id) {
        var goal = goalRepository.findById(id).orElseThrow(GoalNotFoundException::new);

        return goalMapper.toDto(goal);
    }
}
