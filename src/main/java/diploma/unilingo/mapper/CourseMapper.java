package diploma.unilingo.mapper;

import diploma.unilingo.dto.CourseDTO;
import diploma.unilingo.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toDto(Course course);

    Course toEntity(CourseDTO dto);

    @Mapping(target = "id", ignore = true)
    void update(CourseDTO request, @MappingTarget Course course);
}
