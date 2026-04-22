package diploma.unilingo.service.impl;

import diploma.unilingo.entity.Module;
import diploma.unilingo.entity.SubModule;
import diploma.unilingo.repository.ModuleRepository;
import diploma.unilingo.repository.SubModuleRepository;
import diploma.unilingo.service.SubModuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubModuleServiceImpl implements SubModuleService {
    private final SubModuleRepository subModuleRepository;
    private final ModuleRepository moduleRepository;

    public SubModuleServiceImpl(SubModuleRepository subModuleRepository,
                                ModuleRepository moduleRepository) {
        this.subModuleRepository = subModuleRepository;
        this.moduleRepository = moduleRepository;
    }

    // ================= CREATE =================

    @Override
    public SubModule createSubModule(SubModule subModule) {
        return subModuleRepository.save(subModule);
    }

    // ================= GET ONE =================

    @Override
    @Transactional(readOnly = true)
    public SubModule getSubModule(Long id) {
        return subModuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubModule not found"));
    }

    // ================= BY MODULE =================

    @Override
    @Transactional(readOnly = true)
    public List<SubModule> getSubModulesByModule(Long moduleId) {

        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new RuntimeException("Module not found"));

        return subModuleRepository.findByModule(module);
    }
}
