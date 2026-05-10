package diploma.unilingo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "weekly_progress")
public class WeeklyProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Min(value = 0, message = "Week number cannot be less than 0")
    @Max(value = 52, message = "Week number cannot be greater than 52")
    @Column(name = "week_number")
    private int weekNumber;

    @Min(value = 2026, message = "Year cannot be less than 2026")
    @Column(name = "year")
    private int year;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private SubSkillProfile profile;
}
