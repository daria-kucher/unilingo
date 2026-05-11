package diploma.unilingo.mapper;

import diploma.unilingo.dto.WeeklyProgressDTO;
import diploma.unilingo.entity.WeeklyProgress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgressMapper {
    WeeklyProgressDTO toDto(WeeklyProgress progress);

    WeeklyProgress toEntity(WeeklyProgressDTO dto);
}
