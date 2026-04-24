package diploma.unilingo.service.impl;

import diploma.unilingo.dto.ProgressDTO;
import diploma.unilingo.dto.SkillProgressDTO;
import diploma.unilingo.entity.User;
import diploma.unilingo.entity.UserSubSkill;
import diploma.unilingo.repository.UserRepository;
import diploma.unilingo.repository.UserSubSkillRepository;
import diploma.unilingo.service.ProgressService;
import diploma.unilingo.service.SkillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProgressServiceImpl implements ProgressService {
    private final UserRepository userRepository;
    private final UserSubSkillRepository userSubSkillRepository;
    private final SkillService skillService;

    public ProgressServiceImpl(UserRepository userRepository,
                               UserSubSkillRepository userSubSkillRepository,
                               SkillService skillService) {
        this.userRepository = userRepository;
        this.userSubSkillRepository = userSubSkillRepository;
        this.skillService = skillService;
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

        List<SkillProgressDTO> skills =
                skillService.getUserSkillProgress(userId);

        ProgressDTO dto = new ProgressDTO();
        dto.setOverallProgress(overall);
        dto.setWeeklyProgress(weekly);
        dto.setSkills(skills);

        return dto;
    }
}
