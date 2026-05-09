package diploma.unilingo.dto;

import diploma.unilingo.entity.enums.Skill;
import lombok.Data;

@Data
public class SubSkillDTO {
    Long id;
    String name;
    int points;
    Skill skill;
}
