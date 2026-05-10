package diploma.unilingo.entity;

import diploma.unilingo.entity.enums.TestType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TestType type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private List<Exercise> exercises;
}
