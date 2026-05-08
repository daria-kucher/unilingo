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
@Table(name = "goal")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description must be less than 500 characters")
    @Column(name = "description")
    private String description;

    @Min(value = 1, message = "Duration must be at least 1 month")
    @Max(value = 12, message = "Duration must be no more than 12 months")
    @Column(name = "duration_months")
    private int durationMonths;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
