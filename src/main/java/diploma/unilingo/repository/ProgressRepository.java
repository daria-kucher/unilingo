package diploma.unilingo.repository;

import diploma.unilingo.entity.WeeklyProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressRepository extends JpaRepository<WeeklyProgress, Long> {
}
