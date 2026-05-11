package diploma.unilingo.mapper;

import diploma.unilingo.dto.SubModuleDTO;
import diploma.unilingo.entity.SubModule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SubModuleMapper {
    SubModuleDTO toDto(SubModule subModule);

    SubModule toEntity(SubModuleDTO dto);

    @Mapping(target = "id", ignore = true)
    void update(SubModuleDTO request, @MappingTarget SubModule subModule);
}
