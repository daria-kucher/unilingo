package diploma.unilingo.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sub_skill_profile")
public class SubSkillProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private SubSkill conversationManagement;

    @OneToOne(cascade = CascadeType.ALL)
    private SubSkill functionalLanguageUse;

    @OneToOne(cascade = CascadeType.ALL)
    private SubSkill sentenceStructure;

    @OneToOne(cascade = CascadeType.ALL)
    private SubSkill tenseAndAgreement;

    @OneToOne(cascade = CascadeType.ALL)
    private SubSkill wordMeaningAndUsage;

    @OneToOne(cascade = CascadeType.ALL)
    private SubSkill topicSpecificVocabulary;

    @OneToOne(cascade = CascadeType.ALL)
    private SubSkill organizationAndCoherence;

    @OneToOne(cascade = CascadeType.ALL)
    private SubSkill spellingAndPunctuation;
}
