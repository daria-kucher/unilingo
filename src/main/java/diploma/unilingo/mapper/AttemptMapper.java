package diploma.unilingo.mapper;

import diploma.unilingo.dto.AttemptDTO;
import diploma.unilingo.entity.Attempt;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttemptMapper {
    AttemptDTO toDto(Attempt attempt);

    Attempt toEntity(AttemptDTO dto);
}
