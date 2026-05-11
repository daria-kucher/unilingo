package diploma.unilingo.repository;

import diploma.unilingo.entity.WeeklyProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgressRepository extends JpaRepository<WeeklyProgress, Long> {
    List<WeeklyProgress> findAllByUserId(Long userId);
}
