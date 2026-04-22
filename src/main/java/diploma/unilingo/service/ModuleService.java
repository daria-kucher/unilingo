package diploma.unilingo.service;

import diploma.unilingo.entity.Module;

import java.util.List;

public interface ModuleService {
    diploma.unilingo.entity.Module createModule(diploma.unilingo.entity.Module module);

    diploma.unilingo.entity.Module getModule(Long id);

    List<Module> getModulesByCourse(Long courseId);

    boolean isModuleAvailable(Long userId, Long moduleId);
}
