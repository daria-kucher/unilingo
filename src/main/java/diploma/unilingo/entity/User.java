package diploma.unilingo.entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @ManyToOne
    private LanguageLevel level;

    @OneToOne(cascade = CascadeType.ALL)
    private Goal goal;
}
