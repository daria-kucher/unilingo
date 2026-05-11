package diploma.unilingo.mapper;

import diploma.unilingo.dto.ModuleDTO;
import diploma.unilingo.entity.Module;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ModuleMapper {
    ModuleDTO toDto(Module module);

    Module toEntity(ModuleDTO dto);

    @Mapping(target = "id", ignore = true)
    void update(ModuleDTO request, @MappingTarget Module module);
}
