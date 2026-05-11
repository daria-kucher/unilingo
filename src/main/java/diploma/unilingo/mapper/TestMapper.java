package diploma.unilingo.mapper;

import diploma.unilingo.dto.TestDTO;
import diploma.unilingo.entity.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TestMapper {
    TestDTO toDto(Test test);

    Test toEntity(TestDTO dto);

    @Mapping(target = "id", ignore = true)
    void update(TestDTO request, @MappingTarget Test test);
}
