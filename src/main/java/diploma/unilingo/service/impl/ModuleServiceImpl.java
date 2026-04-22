package diploma.unilingo.service.impl;

import diploma.unilingo.entity.Course;
import diploma.unilingo.entity.Module;
import diploma.unilingo.entity.User;
import diploma.unilingo.entity.UserSubSkill;
import diploma.unilingo.repository.CourseRepository;
import diploma.unilingo.repository.ModuleRepository;
import diploma.unilingo.repository.UserSubSkillRepository;
import diploma.unilingo.service.ModuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    private final CourseRepository courseRepository;
    private final UserSubSkillRepository userSubSkillRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository,
                             CourseRepository courseRepository,
                             UserSubSkillRepository userSubSkillRepository) {
        this.moduleRepository = moduleRepository;
        this.courseRepository = courseRepository;
        this.userSubSkillRepository = userSubSkillRepository;
    }

    // ================= CREATE =================

    @Override
    public diploma.unilingo.entity.Module createModule(diploma.unilingo.entity.Module module) {
        return moduleRepository.save(module);
    }

    // ================= GET ONE =================

    @Override
    @Transactional(readOnly = true)
    public diploma.unilingo.entity.Module getModule(Long id) {
        return moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found"));
    }

    // ================= BY COURSE =================

    @Override
    @Transactional(readOnly = true)
    public List<diploma.unilingo.entity.Module> getModulesByCourse(Long courseId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return moduleRepository.findByCourse(course);
    }

    // ================= THRESHOLD LOGIC =================

    @Override
    @Transactional(readOnly = true)
    public boolean isModuleAvailable(Long userId, Long moduleId) {

        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new RuntimeException("Module not found"));

        User user = new User();
        user.setId(userId);

        double avgKnowledge = userSubSkillRepository.findByUser(user)
                .stream()
                .mapToDouble(UserSubSkill::getpKnowledge)
                .average()
                .orElse(0);

        return avgKnowledge >= module.getThreshold();
    }

}
