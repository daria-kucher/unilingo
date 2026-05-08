package diploma.unilingo.mapper;

import diploma.unilingo.dto.SkillDTO;
import diploma.unilingo.entity.Skill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillDTO toDto(Skill skill);

    Skill toEntity(SkillDTO dto);
}
