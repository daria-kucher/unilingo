package diploma.unilingo.service.impl;

import diploma.unilingo.dto.SubSkillDTO;
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
    public SubSkillDTO createSubSkill(SubSkillDTO dto) {
        var subSkill = subSkillMapper.toEntity(dto);
        subSkillRepository.save(subSkill);

        return subSkillMapper.toDto(subSkill);
    }

    @Override
    public SubSkillDTO updateSubSkill(Long id, SubSkillDTO request) {
        var subSkill = subSkillRepository.findSubSkillById(id).orElseThrow(SubSkillNotFoundException::new);

        subSkillMapper.update(request, subSkill);
        subSkillRepository.save(subSkill);

        return subSkillMapper.toDto(subSkill);
    }
}
