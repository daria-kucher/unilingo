package diploma.unilingo.service;

import diploma.unilingo.dto.SubSkillProfileDTO;

public interface SubSkillProfileService {
    SubSkillProfileDTO getProfile(Long id);
    SubSkillProfileDTO createProfile(SubSkillProfileDTO dto);
    SubSkillProfileDTO updateProfile(Long id, SubSkillProfileDTO request);
    SubSkillProfileDTO addProfile(SubSkillProfileDTO target, SubSkillProfileDTO source);
}
