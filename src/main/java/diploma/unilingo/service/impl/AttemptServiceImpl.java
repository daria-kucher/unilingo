package diploma.unilingo.service.impl;

import diploma.unilingo.dto.AttemptDTO;
import diploma.unilingo.exception.attempt.AttemptNotFoundException;
import diploma.unilingo.mapper.AttemptMapper;
import diploma.unilingo.repository.AttemptRepository;
import diploma.unilingo.service.AttemptService;
import org.springframework.stereotype.Service;

@Service
public class AttemptServiceImpl implements AttemptService {
    private final AttemptRepository attemptRepository;
    private final AttemptMapper attemptMapper;

    public AttemptServiceImpl(AttemptRepository attemptRepository, AttemptMapper attemptMapper) {
        this.attemptRepository = attemptRepository;
        this.attemptMapper = attemptMapper;
    }


    @Override
    public AttemptDTO getAttempt(Long id) {
        var attempt = attemptRepository.findById(id).orElseThrow(AttemptNotFoundException::new);

        return attemptMapper.toDto(attempt);
    }

    @Override
    public AttemptDTO createAttempt(AttemptDTO dto) {
        var attempt = attemptMapper.toEntity(dto);
        attemptRepository.save(attempt);

        return attemptMapper.toDto(attempt);
    }
}
