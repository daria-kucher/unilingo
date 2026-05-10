package diploma.unilingo.mapper;

import diploma.unilingo.dto.ExerciseDTO;
import diploma.unilingo.entity.Exercise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {
    ExerciseDTO toDto(Exercise exercise);

    Exercise toEntity(ExerciseDTO dto);

    @Mapping(target = "id", ignore = true)
    void update(ExerciseDTO request, @MappingTarget Exercise exercise);
}
