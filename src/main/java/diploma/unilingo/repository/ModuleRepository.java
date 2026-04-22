package diploma.unilingo.repository;

import diploma.unilingo.entity.Course;
import diploma.unilingo.entity.Module;
import diploma.unilingo.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {
    List<Module> findBySkills(Skill skill);
    List<Module> findByCourse(Course course);
}
