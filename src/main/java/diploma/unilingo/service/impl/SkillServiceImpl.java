package diploma.unilingo.service.impl;

import diploma.unilingo.dto.SkillProgressDTO;
import diploma.unilingo.entity.Skill;
import diploma.unilingo.entity.User;
import diploma.unilingo.entity.UserSubSkill;
import diploma.unilingo.repository.UserRepository;
import diploma.unilingo.repository.UserSubSkillRepository;
import diploma.unilingo.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {
    private final UserRepository userRepository;
    private final UserSubSkillRepository userSubSkillRepository;

    public SkillServiceImpl(UserRepository userRepository,
                            UserSubSkillRepository userSubSkillRepository) {
        this.userRepository = userRepository;
        this.userSubSkillRepository = userSubSkillRepository;
    }

    @Override
    public List<SkillProgressDTO> getUserSkillProgress(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        List<UserSubSkill> userSubSkills =
                userSubSkillRepository.findByUser(user);

        // групуємо по Skill
        Map<Skill, List<UserSubSkill>> grouped =
                userSubSkills.stream()
                        .collect(Collectors.groupingBy(us -> us.getSubSkill().getSkill()));

        List<SkillProgressDTO> result = new ArrayList<>();

        for (Map.Entry<Skill, List<UserSubSkill>> entry : grouped.entrySet()) {

            Skill skill = entry.getKey();
            List<UserSubSkill> subs = entry.getValue();

            double avg = subs.stream()
                    .mapToDouble(UserSubSkill::getpKnowledge)
                    .average()
                    .orElse(0);

            SkillProgressDTO dto = new SkillProgressDTO();
            dto.setSkillName(skill.getName());
            dto.setProgress(avg);

            result.add(dto);
        }

        return result;
    }

    @Override
    public double getSkillProgress(Long userId, Long skillId) {

        User user = userRepository.findById(userId).orElseThrow();

        List<UserSubSkill> subs = userSubSkillRepository.findByUser(user)
                .stream()
                .filter(us -> us.getSubSkill().getSkill().getId().equals(skillId))
                .toList();

        return subs.stream()
                .mapToDouble(UserSubSkill::getpKnowledge)
                .average()
                .orElse(0);
    }
}
