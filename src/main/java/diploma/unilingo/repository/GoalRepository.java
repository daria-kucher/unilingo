package diploma.unilingo.repository;

import diploma.unilingo.entity.Goal;
import diploma.unilingo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    Optional<Goal> findByUser(User user);
}
