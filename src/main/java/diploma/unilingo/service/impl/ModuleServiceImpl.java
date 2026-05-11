package diploma.unilingo.service.impl;

import diploma.unilingo.dto.ModuleDTO;
import diploma.unilingo.exception.module.ModuleNotFoundException;
import diploma.unilingo.mapper.ModuleMapper;
import diploma.unilingo.repository.ModuleRepository;
import diploma.unilingo.service.ModuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper;

    public ModuleServiceImpl(ModuleRepository moduleRepository, ModuleMapper moduleMapper) {
        this.moduleRepository = moduleRepository;
        this.moduleMapper = moduleMapper;
    }


    @Override
    public ModuleDTO getModule(Long id) {
        var module = moduleRepository.findById(id).orElseThrow(ModuleNotFoundException::new);

        return moduleMapper.toDto(module);
    }

    @Override
    public List<ModuleDTO> getAllModulesByCourse(Long courseId) {
        return moduleRepository.findAllByCourseId(courseId)
                .stream()
                .map(moduleMapper::toDto)
                .toList();
    }

    @Override
    public ModuleDTO createModule(ModuleDTO dto) {
        var module = moduleMapper.toEntity(dto);
        moduleRepository.save(module);

        return moduleMapper.toDto(module);
    }

    @Override
    public ModuleDTO updateModule(Long id, ModuleDTO request) {
        var module = moduleRepository.findById(id).orElseThrow(ModuleNotFoundException::new);

        moduleMapper.update(request, module);
        moduleRepository.save(module);

        return moduleMapper.toDto(module);
    }

    @Override
    public void deleteModule(Long id) {
        var module = moduleRepository.findById(id).orElseThrow(ModuleNotFoundException::new);

        moduleRepository.delete(module);
    }
}
