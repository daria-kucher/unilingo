package diploma.unilingo.service;

import diploma.unilingo.dto.LanguageLevelDTO;

import java.util.List;

public interface LanguageLevelService {
    List<LanguageLevelDTO> getAllLevels();
    LanguageLevelDTO getLevel(Long id);
    LanguageLevelDTO createLevel(LanguageLevelDTO dto);
    LanguageLevelDTO updateLevel(Long id, LanguageLevelDTO request);
}
