package diploma.unilingo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "skill", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be less than 255 characters")
    @Column(name = "name")
    private String name;
}
