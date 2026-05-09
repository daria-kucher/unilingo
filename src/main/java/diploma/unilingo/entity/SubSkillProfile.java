package diploma.unilingo.entity;


import diploma.unilingo.entity.enums.Skill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
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

    public SubSkillProfile() {
        conversationManagement =
                new SubSkill(null, "Conversation Management", 0,
                        Skill.COMMUNICATIVE_PRAGMATICS);

        functionalLanguageUse =
                new SubSkill(null, "Functional Language Use", 0,
                        Skill.COMMUNICATIVE_PRAGMATICS);

        sentenceStructure =
                new SubSkill(null, "Sentence Structure", 0,
                        Skill.GRAMMAR);

        tenseAndAgreement =
                new SubSkill(null, "Tense and Agreement", 0,
                        Skill.GRAMMAR);

        wordMeaningAndUsage =
                new SubSkill(null, "Word Meaning and Usage", 0,
                        Skill.VOCABULARY);

        topicSpecificVocabulary =
                new SubSkill(null, "Topic-Specific Vocabulary", 0,
                        Skill.VOCABULARY);

        organizationAndCoherence =
                new SubSkill(null, "Organization and Coherence", 0,
                        Skill.WRITING);

        spellingAndPunctuation =
                new SubSkill(null, "Spelling and Punctuation", 0,
                        Skill.WRITING);
    }
}
