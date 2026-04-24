package diploma.unilingo.dto;

import java.util.List;

public class ProgressDTO {
    private double overallProgress;
    private double weeklyProgress;
    private List<SkillProgressDTO> skills;

    public double getOverallProgress() {
        return overallProgress;
    }

    public void setOverallProgress(double overallProgress) {
        this.overallProgress = overallProgress;
    }

    public double getWeeklyProgress() {
        return weeklyProgress;
    }

    public void setWeeklyProgress(double weeklyProgress) {
        this.weeklyProgress = weeklyProgress;
    }

    public List<SkillProgressDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillProgressDTO> skills) {
        this.skills = skills;
    }
}
