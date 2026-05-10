package diploma.unilingo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @NotBlank(message = "Answer text is required")
    @Column(name = "text")
    private String text;

    @Column(name = "is_correct")
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
}
