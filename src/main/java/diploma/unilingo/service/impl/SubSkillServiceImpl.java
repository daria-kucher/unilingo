package diploma.unilingo.service.impl;

import diploma.unilingo.dto.SubSkillDTO;
import diploma.unilingo.entity.SubSkill;
import diploma.unilingo.entity.enums.Skill;
import diploma.unilingo.exception.subskill.SubSkillNotFoundException;
import diploma.unilingo.mapper.SubSkillMapper;
import diploma.unilingo.repository.SubSkillRepository;
import diploma.unilingo.service.SubSkillService;
import org.springframework.stereotype.Service;

@Service
public class SubSkillServiceImpl implements SubSkillService {
    private final SubSkillRepository subSkillRepository;
    private final SubSkillMapper subSkillMapper;

    public SubSkillServiceImpl(SubSkillRepository subSkillRepository, SubSkillMapper subSkillMapper) {
        this.subSkillRepository = subSkillRepository;
        this.subSkillMapper = subSkillMapper;
    }

    @Override
    public SubSkillDTO getSubSkill(Long id) {
        var subSkill = subSkillRepository.findSubSkillById(id).orElseThrow(SubSkillNotFoundException::new);

        return subSkillMapper.toDto(subSkill);
    }

    @Override
    public SubSkill createSubSkill(String name, Skill skill) {
        return SubSkill.builder()
                .name(name)
                .points(0)
                .skill(skill)
                .build();
    }


    @Override
    public SubSkillDTO updateSubSkill(Long id, SubSkillDTO request) {
        var subSkill = subSkillRepository.findSubSkillById(id).orElseThrow(SubSkillNotFoundException::new);

        subSkillMapper.update(request, subSkill);
        subSkillRepository.save(subSkill);

        return subSkillMapper.toDto(subSkill);
    }

    @Override
    public void addPoints(SubSkill target, SubSkill source) {
        target.setPoints(target.getPoints() + source.getPoints());
    }
}
