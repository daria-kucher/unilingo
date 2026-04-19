package diploma.unilingo.entity;

import jakarta.persistence.*;

@Entity
public class SubModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 5000)
    private String theory;

    @ManyToOne
    private Module module;
}
