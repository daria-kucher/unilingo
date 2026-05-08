package diploma.unilingo.dto;

import lombok.Data;

@Data
public class GoalDTO {
    private Long id;
    private String description;
    private int durationMonths;
    private Long userId;
}
