package diploma.unilingo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "attempt")
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Builder.Default
    @Column(name = "correct")
    private boolean correct = false;

    @Column(name = "start_time")
    private LocalDateTime start;

    @Column(name = "finish_time")
    private LocalDateTime finish;
}
