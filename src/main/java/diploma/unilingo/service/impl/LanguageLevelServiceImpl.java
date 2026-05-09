package diploma.unilingo.service.impl;

import diploma.unilingo.dto.LanguageLevelDTO;
import diploma.unilingo.exception.languageLevel.DuplicateLevelException;
import diploma.unilingo.exception.languageLevel.LanguageLevelNotFoundException;
import diploma.unilingo.mapper.LanguageLevelMapper;
import diploma.unilingo.repository.LanguageLevelRepository;
import diploma.unilingo.service.LanguageLevelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageLevelServiceImpl implements LanguageLevelService {
    private final LanguageLevelRepository levelRepository;
    private final LanguageLevelMapper levelMapper;

    public LanguageLevelServiceImpl(LanguageLevelRepository levelRepository, LanguageLevelMapper levelMapper) {
        this.levelRepository = levelRepository;
        this.levelMapper = levelMapper;
    }

    @Override
    public List<LanguageLevelDTO> getAllLevels() {
        return levelRepository.findAll()
                .stream()
                .map(levelMapper::toDto)
                .toList();
    }

    @Override
    public LanguageLevelDTO getLevel(Long id) {
        var level = levelRepository.findById(id).orElseThrow(LanguageLevelNotFoundException::new);

        return levelMapper.toDto(level);
    }

    @Override
    public LanguageLevelDTO createLevel(LanguageLevelDTO dto) {
        if (levelRepository.existsByName(dto.getName()))
            throw new DuplicateLevelException();

        var level = levelMapper.toEntity(dto);
        levelRepository.save(level);

        return levelMapper.toDto(level);
    }

    @Override
    public LanguageLevelDTO updateLevel(Long id, LanguageLevelDTO request) {
        var level = levelRepository.findById(id).orElseThrow(LanguageLevelNotFoundException::new);

        levelMapper.update(request, level);
        levelRepository.save(level);

        return levelMapper.toDto(level);
    }
}
