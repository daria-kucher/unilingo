package diploma.unilingo.service;

import diploma.unilingo.dto.CourseDTO;
import diploma.unilingo.entity.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(CourseDTO dto);
    Course updateCourse(Long id, CourseDTO dto);
    Course getCourse(Long id);
    List<Course> getAllCourses();
}
