package diploma.unilingo.dto;

import lombok.Data;

@Data
public class SubSkillProfileDTO {
    private Long id;

    private SubSkillDTO conversationManagement;

    private SubSkillDTO functionalLanguageUse;

    private SubSkillDTO sentenceStructure;

    private SubSkillDTO tenseAndAgreement;

    private SubSkillDTO wordMeaningAndUsage;

    private SubSkillDTO topicSpecificVocabulary;

    private SubSkillDTO organizationAndCoherence;

    private SubSkillDTO spellingAndPunctuation;
}
