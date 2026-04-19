package diploma.unilingo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Exercise exercise;

    private boolean correct;

    private double timeSpent;

    private LocalDateTime timestamp;
}
