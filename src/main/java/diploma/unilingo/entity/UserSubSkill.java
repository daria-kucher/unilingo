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
}
