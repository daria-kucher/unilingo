package diploma.unilingo.mapper;

import diploma.unilingo.dto.AnswerDTO;
import diploma.unilingo.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    @Mapping(target = "exerciseId", source = "exercise.id")
    AnswerDTO toDto(Answer answer);

    Answer toEntity (AnswerDTO dto);

    @Mapping(target = "id", ignore = true)
    void update(AnswerDTO dto, @MappingTarget Answer answer);
}
