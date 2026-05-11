package diploma.unilingo.service;

import diploma.unilingo.dto.ModuleDTO;

import java.util.List;

public interface ModuleService {
    ModuleDTO getModule(Long id);
    List<ModuleDTO> getAllModulesByCourse(Long courseId);
    ModuleDTO createModule(ModuleDTO dto);
    ModuleDTO updateModule(Long id, ModuleDTO request);
    void deleteModule(Long id);
}
