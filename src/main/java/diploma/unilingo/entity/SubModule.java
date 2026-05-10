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
@Table(name = "sub_module")
public class SubModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be less than 255 characters")
    @Column(name = "name")
    private String name;

    @Column(name = "theory", length = 5000)
    private String theory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private SubSkillProfile profile;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    @Column(name = "completed")
    private boolean completed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private Test test;
}
