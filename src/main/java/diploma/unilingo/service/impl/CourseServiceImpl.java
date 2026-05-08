package diploma.unilingo.service.impl;

import diploma.unilingo.dto.CourseDTO;
import diploma.unilingo.exception.course.CourseNotFoundException;
import diploma.unilingo.exception.course.DuplicateCourseException;
import diploma.unilingo.mapper.CourseMapper;
import diploma.unilingo.repository.CourseRepository;
import diploma.unilingo.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseDTO createCourse(CourseDTO dto) {
        if (courseRepository.existsByName(dto.getName()))
            throw new DuplicateCourseException();

        var course = courseMapper.toEntity(dto);
        courseRepository.save(course);

        return courseMapper.toDto(course);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO request) {
        var course = courseRepository.findCourseById(id).orElseThrow(CourseNotFoundException::new);
        System.out.println(course);

        courseMapper.update(request, course);
        courseRepository.save(course);

        return courseMapper.toDto(course);
    }

    @Override
    public void deleteCourse(Long id) {
        var course = courseRepository.findCourseById(id).orElseThrow(CourseNotFoundException::new);

        courseRepository.delete(course);
    }

    @Override
    public CourseDTO getCourse(Long id) {
        var course = courseRepository.findCourseById(id).orElseThrow(CourseNotFoundException::new);

        return courseMapper.toDto(course);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDto)
                .toList();
    }
}
