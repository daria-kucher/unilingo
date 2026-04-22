package diploma.unilingo.dto;


import java.util.List;

public class ExerciseResponseDTO {
    private Long id;
    private String question;
    private List<String> options;

    public ExerciseResponseDTO() {}

    public ExerciseResponseDTO(Long id, String question, List<String> options) {
        this.id = id;
        this.question = question;
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
