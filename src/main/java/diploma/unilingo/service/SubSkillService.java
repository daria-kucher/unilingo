package diploma.unilingo.service;

import diploma.unilingo.dto.SubSkillDTO;

public interface SubSkillService {
    SubSkillDTO getSubSkill(Long id);
    SubSkillDTO createSubSkill(SubSkillDTO dto);
    SubSkillDTO updateSubSkill(Long id, SubSkillDTO request);
}
