package diploma.unilingo.service.impl;

import diploma.unilingo.dto.WeeklyProgressDTO;
import diploma.unilingo.exception.weeklyprogress.ProgressNotFoundException;
import diploma.unilingo.mapper.ProgressMapper;
import diploma.unilingo.repository.ProgressRepository;
import diploma.unilingo.service.ProgressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressServiceImpl implements ProgressService {
    private final ProgressRepository progressRepository;
    private final ProgressMapper progressMapper;

    public ProgressServiceImpl(ProgressRepository progressRepository, ProgressMapper progressMapper) {
        this.progressRepository = progressRepository;
        this.progressMapper = progressMapper;
    }


    @Override
    public WeeklyProgressDTO getProgress(Long id) {
        var progress = progressRepository.findById(id).orElseThrow(ProgressNotFoundException::new);

        return progressMapper.toDto(progress);
    }

    @Override
    public List<WeeklyProgressDTO> getProgressesByUserId(Long userId) {
        return progressRepository.findAllByUserId(userId)
                .stream()
                .map(progressMapper::toDto)
                .toList();
    }

    @Override
    public WeeklyProgressDTO createProgress(WeeklyProgressDTO dto) {
        var progress = progressMapper.toEntity(dto);
        progressRepository.save(progress);

        return progressMapper.toDto(progress);
    }
}
