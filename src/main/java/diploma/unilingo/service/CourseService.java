package diploma.unilingo.service;

import diploma.unilingo.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    CourseDTO createCourse(CourseDTO dto);
    CourseDTO updateCourse(Long id, CourseDTO request);
    void deleteCourse(Long id);
    CourseDTO getCourse(Long id);
    List<CourseDTO> getAllCourses();
}
