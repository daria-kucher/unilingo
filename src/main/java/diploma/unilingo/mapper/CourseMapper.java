package diploma.unilingo.mapper;

import diploma.unilingo.dto.CourseDTO;
import diploma.unilingo.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toDto(Course course);
}
