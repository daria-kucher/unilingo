package diploma.unilingo.entity;

import jakarta.persistence.*;

@Entity
public class ExerciseSubSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Exercise exercise;

    @ManyToOne
    private SubSkill subSkill;

    private double weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public SubSkill getSubSkill() {
        return subSkill;
    }

    public void setSubSkill(SubSkill subSkill) {
        this.subSkill = subSkill;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
