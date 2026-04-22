package diploma.unilingo.repository;

import diploma.unilingo.entity.Module;
import diploma.unilingo.entity.SubModule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubModuleRepository extends JpaRepository<SubModule, Long> {
    List<SubModule> findByModule(Module module);
}
