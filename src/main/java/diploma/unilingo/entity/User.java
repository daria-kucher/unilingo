package diploma.unilingo.entity;

import diploma.unilingo.entity.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @NotBlank(message = "Username is required")
    @Size(max = 255, message = "Username must be less than 255 characters")
    @Column(name = "username", unique = true)
    private String username;

    @NonNull
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(name = "email", unique = true)
    private String email;

    @NonNull
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must contain at least 6 characters")
    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "level_id")
    private LanguageLevel level;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private SubSkillProfile profile;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
