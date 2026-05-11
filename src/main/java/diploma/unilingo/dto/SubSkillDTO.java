package diploma.unilingo.dto;

import diploma.unilingo.entity.enums.Skill;
import lombok.Data;

@Data
public class SubSkillDTO {
    private Long id;
    private String name;
    private int points;
    private Skill skill;
}
