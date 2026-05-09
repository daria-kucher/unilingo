package diploma.unilingo.repository;

import diploma.unilingo.entity.Exercise;
import diploma.unilingo.entity.SubSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findBySubSkills(@Param("subSkill") SubSkill subSkill);
}
