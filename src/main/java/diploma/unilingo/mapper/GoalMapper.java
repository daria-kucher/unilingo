package diploma.unilingo.mapper;

import diploma.unilingo.dto.GoalDTO;
import diploma.unilingo.entity.Goal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GoalMapper {
    GoalDTO toDto(Goal goal);

    Goal toEntity(GoalDTO goalDTO);
}
