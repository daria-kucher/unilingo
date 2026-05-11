package diploma.unilingo.service.impl;

import diploma.unilingo.dto.SubModuleDTO;
import diploma.unilingo.exception.submodule.SubModuleNotFoundException;
import diploma.unilingo.mapper.SubModuleMapper;
import diploma.unilingo.repository.SubModuleRepository;
import diploma.unilingo.service.SubModuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubModuleServiceImpl implements SubModuleService {
    private final SubModuleRepository subModuleRepository;
    private final SubModuleMapper subModuleMapper;

    public SubModuleServiceImpl(SubModuleRepository subModuleRepository, SubModuleMapper subModuleMapper) {
        this.subModuleRepository = subModuleRepository;
        this.subModuleMapper = subModuleMapper;
    }


    @Override
    public SubModuleDTO getSubModule(Long id) {
        var subModule = subModuleRepository.findById(id).orElseThrow(SubModuleNotFoundException::new);

        return subModuleMapper.toDto(subModule);
    }

    @Override
    public List<SubModuleDTO> getSubModulesByModuleId(Long moduleId) {
        return subModuleRepository.findAllByModuleId(moduleId)
                .stream()
                .map(subModuleMapper::toDto)
                .toList();
    }

    @Override
    public SubModuleDTO createSubModule(SubModuleDTO dto) {
        var subModule = subModuleMapper.toEntity(dto);
        subModuleRepository.save(subModule);

        return subModuleMapper.toDto(subModule);
    }

    @Override
    public SubModuleDTO updateSubModule(Long id, SubModuleDTO request) {
        var subModule = subModuleRepository.findById(id).orElseThrow(SubModuleNotFoundException::new);

        subModuleMapper.update(request, subModule);
        subModuleRepository.save(subModule);

        return subModuleMapper.toDto(subModule);
    }

    @Override
    public void delete(Long id) {
        var subModule = subModuleRepository.findById(id).orElseThrow(SubModuleNotFoundException::new);

        subModuleRepository.delete(subModule);
    }
}
