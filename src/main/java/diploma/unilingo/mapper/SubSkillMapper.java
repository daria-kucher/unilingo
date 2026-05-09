package diploma.unilingo.mapper;

import diploma.unilingo.dto.SubSkillDTO;
import diploma.unilingo.entity.SubSkill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SubSkillMapper {
    SubSkillDTO toDto(SubSkill subSkill);

    SubSkill toEntity(SubSkillDTO dto);

    @Mapping(target = "id", ignore = true)
    void update(SubSkillDTO request, @MappingTarget SubSkill subSkill);
}
