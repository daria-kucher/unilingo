package diploma.unilingo.mapper;

import diploma.unilingo.dto.LanguageLevelDTO;
import diploma.unilingo.entity.LanguageLevel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LanguageLevelMapper {
    LanguageLevelDTO toDto(LanguageLevel level);

    LanguageLevel toEntity(LanguageLevelDTO request);

    @Mapping(target = "id", ignore = true)
    void update(LanguageLevelDTO request, @MappingTarget LanguageLevel level);
}
