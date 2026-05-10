package diploma.unilingo.mapper;

import diploma.unilingo.dto.SubSkillProfileDTO;
import diploma.unilingo.entity.SubSkillProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SubSkillProfileMapper {
    SubSkillProfileDTO toDto(SubSkillProfile profile);

    SubSkillProfile toEntity(SubSkillProfileDTO dto);

    @Mapping(target = "id", ignore = true)
    void update(SubSkillProfileDTO request, @MappingTarget SubSkillProfile profile);
}
