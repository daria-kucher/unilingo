package diploma.unilingo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttemptDTO {
    private Long id;

    private UserDTO user;

    private ExerciseDTO exercise;

    private AnswerDTO answer;

    private boolean correct;

    private LocalDateTime start;

    private LocalDateTime finish;
}
