package diploma.unilingo.entity;

import jakarta.persistence.*;

@Entity
public class UserSubSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private SubSkill subSkill;

    private double pKnowledge;

    private double weeklyScore; // для прогресу за тиждень

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SubSkill getSubSkill() {
        return subSkill;
    }

    public void setSubSkill(SubSkill subSkill) {
        this.subSkill = subSkill;
    }

    public double getpKnowledge() {
        return pKnowledge;
    }

    public void setpKnowledge(double pKnowledge) {
        this.pKnowledge = pKnowledge;
    }

    public double getWeeklyScore() {
        return weeklyScore;
    }

    public void setWeeklyScore(double weeklyScore) {
        this.weeklyScore = weeklyScore;
    }
}
