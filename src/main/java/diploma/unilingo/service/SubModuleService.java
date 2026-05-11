package diploma.unilingo.service;

import diploma.unilingo.dto.SubModuleDTO;

import java.util.List;

public interface SubModuleService {
    SubModuleDTO getSubModule(Long id);
    List<SubModuleDTO> getSubModulesByModuleId(Long moduleId);
    SubModuleDTO createSubModule(SubModuleDTO dto);
    SubModuleDTO updateSubModule(Long id, SubModuleDTO request);
    void delete(Long id);
}
