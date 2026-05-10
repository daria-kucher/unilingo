package diploma.unilingo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @NotBlank(message = "Question is required")
    @Column(name = "question", columnDefinition = "TEXT")
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "exercise_id")
    private List<Answer> answers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private SubSkillProfile profile;
}
