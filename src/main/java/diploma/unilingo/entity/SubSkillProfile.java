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
    @JoinColumn(name = "conversation_management_id")
    private SubSkill conversationManagement;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "functional_language_use_id")
    private SubSkill functionalLanguageUse;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sentence_structure_id")
    private SubSkill sentenceStructure;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tense_and_agreement_id")
    private SubSkill tenseAndAgreement;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "word_meaning_and_usage_id")
    private SubSkill wordMeaningAndUsage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_specific_vocabulary_id")
    private SubSkill topicSpecificVocabulary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_and_coherence_id")
    private SubSkill organizationAndCoherence;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spelling_and_punctuation_id")
    private SubSkill spellingAndPunctuation;
}
