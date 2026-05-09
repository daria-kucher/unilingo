package diploma.unilingo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
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
@Table(name = "language_level",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class LanguageLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be less than 255 characters")
    @Column(name = "name", unique = true)
    private String name;

    @Min(value = 0, message = "Threshold cannot be less than 0")
    @Max(value = 6000, message = "Threshold cannot be greater than 6000")
    @Column(name = "threshold")
    private double threshold;
}
