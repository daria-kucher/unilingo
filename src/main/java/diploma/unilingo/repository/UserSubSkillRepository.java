package diploma.unilingo.repository;

import diploma.unilingo.entity.Goal;
import diploma.unilingo.entity.SubSkill;
import diploma.unilingo.entity.User;
import diploma.unilingo.entity.UserSubSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserSubSkillRepository extends JpaRepository<UserSubSkill, Long> {
    List<UserSubSkill> findByUser(User user);

    Optional<UserSubSkill> findByUserAndSubSkill(User user, SubSkill subSkill);
}
