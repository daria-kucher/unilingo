package diploma.unilingo.service.impl;

import diploma.unilingo.dto.ProgressDTO;
import diploma.unilingo.dto.SkillProgressDTO;
import diploma.unilingo.entity.User;
import diploma.unilingo.entity.UserSubSkill;
import diploma.unilingo.repository.UserRepository;
import diploma.unilingo.repository.UserSubSkillRepository;
import diploma.unilingo.service.ProgressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProgressServiceImpl implements ProgressService {
    private final UserRepository userRepository;
    private final UserSubSkillRepository userSubSkillRepository;

    public ProgressServiceImpl(UserRepository userRepository,
                               UserSubSkillRepository userSubSkillRepository
                            ) {
        this.userRepository = userRepository;
        this.userSubSkillRepository = userSubSkillRepository;

    }

    @Override
    public ProgressDTO getUserProgress(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<UserSubSkill> userSubSkills =
                userSubSkillRepository.findByUser(user);

        double overall = userSubSkills.stream()
                .mapToDouble(UserSubSkill::getpKnowledge)
                .average()
                .orElse(0);

        double weekly = userSubSkills.stream()
                .mapToDouble(UserSubSkill::getWeeklyScore)
                .sum();



        ProgressDTO dto = new ProgressDTO();
        dto.setOverallProgress(overall);
        dto.setWeeklyProgress(weekly);

        return dto;
    }
}
