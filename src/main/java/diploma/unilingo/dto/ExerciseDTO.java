package diploma.unilingo.dto;

import java.util.List;

public class ExerciseDTO {
    private String question;
    private String correctAnswer;
    private List<String> wrongAnswers;
    private List<Long> subSkillIds;

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

    public List<Long> getSubSkillIds() {
        return subSkillIds;
    }

    public void setSubSkillIds(List<Long> subSkillIds) {
        this.subSkillIds = subSkillIds;
    }
}
