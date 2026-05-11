package diploma.unilingo.dto;

import diploma.unilingo.entity.enums.TestType;
import lombok.Data;

import java.util.List;

@Data
public class TestDTO {
    private Long id;

    private TestType type;

    private List<ExerciseDTO> exercises;
}
