package diploma.unilingo.dto;

import lombok.Data;

@Data
public class WeeklyProgressDTO {
    private Long id;

    private UserDTO user;

    private int weekNumber;

    private int year;

    private SubSkillProfileDTO profile;
}
