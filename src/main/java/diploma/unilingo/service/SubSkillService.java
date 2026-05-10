package diploma.unilingo.service;

import diploma.unilingo.dto.SubSkillDTO;
import diploma.unilingo.entity.SubSkill;
import diploma.unilingo.entity.enums.Skill;

public interface SubSkillService {
    SubSkillDTO getSubSkill(Long id);
    SubSkill createSubSkill(String name, Skill skill);
    SubSkillDTO updateSubSkill(Long id, SubSkillDTO request);
    void addPoints(SubSkill target, SubSkill source);
}
