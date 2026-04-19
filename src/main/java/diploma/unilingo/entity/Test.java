package diploma.unilingo.entity;

import jakarta.persistence.*;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TestType type;

    @ManyToOne
    private Module module;

    @ManyToOne
    private SubModule subModule;
}
