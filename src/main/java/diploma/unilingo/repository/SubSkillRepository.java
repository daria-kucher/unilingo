package diploma.unilingo.repository;

import diploma.unilingo.entity.SubSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubSkillRepository extends JpaRepository<SubSkill, Long> {
    Optional<SubSkill> findSubSkillById(Long id);
    SubSkill findSubSkillByName(String name);
}
