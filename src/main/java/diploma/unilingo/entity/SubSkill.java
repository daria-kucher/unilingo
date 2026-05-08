package diploma.unilingo.entity;

import diploma.unilingo.entity.enums.Skill;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sub_skill", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class SubSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be less than 255 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Points cannot be negative")
    @Column(name = "points")
    private int points;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "skill")
    private Skill skill;
}
