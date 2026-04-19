package diploma.unilingo.entity;

import jakarta.persistence.*;

@Entity
public class WeeklyProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private int weekNumber;
    private int year;

    private double totalScore;
}
