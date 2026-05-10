package diploma.unilingo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be less than 255 characters")
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private SubSkillProfile profile;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "completed")
    private boolean completed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "module_id")
    private List<SubModule> subModules;
}
