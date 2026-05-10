package diploma.unilingo.service.impl;

import diploma.unilingo.dto.SubSkillProfileDTO;
import diploma.unilingo.entity.SubSkillProfile;
import diploma.unilingo.entity.enums.Skill;
import diploma.unilingo.exception.subskillProfile.SubSkillProfileNotFoundException;
import diploma.unilingo.mapper.SubSkillProfileMapper;
import diploma.unilingo.repository.SubSkillProfileRepository;
import diploma.unilingo.service.SubSkillProfileService;
import diploma.unilingo.service.SubSkillService;
import org.springframework.stereotype.Service;

@Service
public class SubSkillProfileServiceImpl implements SubSkillProfileService {
    private final SubSkillProfileRepository profileRepository;
    private final SubSkillProfileMapper profileMapper;
    private final SubSkillService subSkillService;

    public SubSkillProfileServiceImpl(SubSkillProfileRepository profileRepository, SubSkillProfileMapper profileMapper, SubSkillService subSkillService) {
        this.profileRepository = profileRepository;
        this.profileMapper = profileMapper;
        this.subSkillService = subSkillService;
    }

    @Override
    public SubSkillProfileDTO getProfile(Long id) {
        var profile = profileRepository.findById(id)
                .orElseThrow(SubSkillProfileNotFoundException::new);

        return profileMapper.toDto(profile);
    }

    // REWRITE
    @Override
    public SubSkillProfileDTO createProfile(SubSkillProfileDTO dto) {
        SubSkillProfile profile = SubSkillProfile.builder()

                .conversationManagement(
                        subSkillService.createSubSkill(
                                "Conversation Management",
                                Skill.COMMUNICATIVE_PRAGMATICS)
                )

                .functionalLanguageUse(
                        subSkillService.createSubSkill(
                                "Functional Language Use",
                                Skill.COMMUNICATIVE_PRAGMATICS)
                )

                .sentenceStructure(
                        subSkillService.createSubSkill(
                                "Sentence Structure",
                                Skill.GRAMMAR)
                )

                .tenseAndAgreement(
                        subSkillService.createSubSkill(
                                "Tense and Agreement",
                                Skill.GRAMMAR)
                )

                .wordMeaningAndUsage(
                        subSkillService.createSubSkill(
                                "Word Meaning and Usage",
                                Skill.VOCABULARY)
                )

                .topicSpecificVocabulary(
                        subSkillService.createSubSkill(
                                "Topic-Specific Vocabulary",
                                Skill.VOCABULARY)
                )

                .organizationAndCoherence(
                        subSkillService.createSubSkill(
                                "Organization and Coherence",
                                Skill.WRITING)
                )

                .spellingAndPunctuation(
                        subSkillService.createSubSkill(
                                "Spelling and Punctuation",
                                Skill.WRITING)
                )

                .build();

        profileRepository.save(profile);

        return profileMapper.toDto(profile);
    }

    @Override
    public SubSkillProfileDTO updateProfile(Long id, SubSkillProfileDTO request) {
        var profile = profileRepository.findById(id).orElseThrow(SubSkillProfileNotFoundException::new);

        profileMapper.update(request, profile);
        profileRepository.save(profile);

        return profileMapper.toDto(profile);
    }

    @Override
    public SubSkillProfileDTO addProfile(SubSkillProfileDTO targetDto, SubSkillProfileDTO sourceDto) {
        SubSkillProfile target =
                profileRepository.findById(targetDto.getId())
                        .orElseThrow(() -> new RuntimeException("Target profile not found"));

        SubSkillProfile source =
                profileRepository.findById(sourceDto.getId())
                        .orElseThrow(() -> new RuntimeException("Source profile not found"));

        subSkillService.addPoints(target.getConversationManagement(),
                source.getConversationManagement());

        subSkillService.addPoints(target.getFunctionalLanguageUse(),
                source.getFunctionalLanguageUse());

        subSkillService.addPoints(target.getSentenceStructure(),
                source.getSentenceStructure());

        subSkillService.addPoints(target.getTenseAndAgreement(),
                source.getTenseAndAgreement());

        subSkillService.addPoints(target.getWordMeaningAndUsage(),
                source.getWordMeaningAndUsage());

        subSkillService.addPoints(target.getTopicSpecificVocabulary(),
                source.getTopicSpecificVocabulary());

        subSkillService.addPoints(target.getOrganizationAndCoherence(),
                source.getOrganizationAndCoherence());

        subSkillService.addPoints(target.getSpellingAndPunctuation(),
                source.getSpellingAndPunctuation());

        profileRepository.save(target);

        return profileMapper.toDto(target);
    }
}
