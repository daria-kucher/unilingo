package diploma.unilingo.entity;

import jakarta.persistence.*;

@Entity
public class SubSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Skill skill;
}
