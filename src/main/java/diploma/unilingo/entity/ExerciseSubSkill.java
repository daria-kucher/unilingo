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
}
