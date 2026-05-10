package diploma.unilingo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExerciseDTO {
    private Long id;
    private String question;
    private List<AnswerDTO> answers;
    private SubSkillProfileDTO profile;
}
