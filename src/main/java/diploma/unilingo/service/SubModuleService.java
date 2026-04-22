package diploma.unilingo.service;

import diploma.unilingo.entity.SubModule;

import java.util.List;

public interface SubModuleService {
    SubModule createSubModule(SubModule subModule);

    SubModule getSubModule(Long id);

    List<SubModule> getSubModulesByModule(Long moduleId);
}
