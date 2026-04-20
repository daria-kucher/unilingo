package diploma.unilingo.service.impl;

import diploma.unilingo.dto.GoalDTO;
import diploma.unilingo.entity.Goal;
import diploma.unilingo.entity.User;
import diploma.unilingo.entity.UserSubSkill;
import diploma.unilingo.repository.GoalRepository;
import diploma.unilingo.repository.UserRepository;
import diploma.unilingo.repository.UserSubSkillRepository;
import diploma.unilingo.service.GoalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalServiceImpl implements GoalService {
    private final GoalRepository goalRepository;
    private final UserRepository userRepository;
    private final UserSubSkillRepository userSubSkillRepository;

    public GoalServiceImpl(GoalRepository goalRepository,
                           UserRepository userRepository,
                           UserSubSkillRepository userSubSkillRepository) {
        this.goalRepository = goalRepository;
        this.userRepository = userRepository;
        this.userSubSkillRepository = userSubSkillRepository;
    }

    @Override
    public Goal createOrUpdateGoal(Long userId, GoalDTO dto) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        Goal goal = goalRepository.findByUser(user)
                .orElse(new Goal());

        goal.setUser(user);
        goal.setDescription(dto.getDescription());
        goal.setDurationMonths(dto.getDurationMonths());

        return goalRepository.save(goal);
    }

    @Override
    public Goal getUserGoal(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return goalRepository.findByUser(user).orElseThrow();
    }

    @Override
    public double calculateProgress(Long userId) {

        User user = userRepository.findById(userId).orElseThrow();

        List<UserSubSkill> skills = userSubSkillRepository.findByUser(user);

        double avg = skills.stream()
                .mapToDouble(UserSubSkill::getpKnowledge)
                .average()
                .orElse(0);

        return avg; // 0..1
    }
}
