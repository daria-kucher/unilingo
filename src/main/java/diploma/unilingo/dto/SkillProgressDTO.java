package diploma.unilingo.dto;

public class SkillProgressDTO {
    private String skillName;
    private double progress; // 0..1

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
