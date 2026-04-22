package diploma.unilingo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String correctAnswer;

    @ElementCollection
    private List<String> wrongAnswers;

    public List<ExerciseSubSkill> getExerciseSubSkills() {
        return exerciseSubSkills;
    }

    public void setExerciseSubSkills(List<ExerciseSubSkill> exerciseSubSkills) {
        this.exerciseSubSkills = exerciseSubSkills;
    }

    // 🔥 ВАЖЛИВО
    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    private List<ExerciseSubSkill> exerciseSubSkills;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(List<String> wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }
}
