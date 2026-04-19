package diploma.unilingo.entity;

import jakarta.persistence.*;

@Entity
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double threshold;

    @ManyToOne
    private Course course;
}
