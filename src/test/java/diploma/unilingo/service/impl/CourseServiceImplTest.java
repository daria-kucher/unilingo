package diploma.unilingo.service.impl;

import diploma.unilingo.dto.CourseDTO;
import diploma.unilingo.entity.Course;
import diploma.unilingo.exception.CourseNotFoundException;
import diploma.unilingo.exception.DuplicateCourseException;
import diploma.unilingo.mapper.CourseMapper;
import diploma.unilingo.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private CourseMapper courseMapper;

    @InjectMocks
    private CourseServiceImpl courseService;

    private Course course;
    private CourseDTO courseDTO;

    @BeforeEach
    void setUp() {
        course = new Course();
        course.setId(1L);
        course.setName("Java Basics");

        courseDTO = new CourseDTO();
        courseDTO.setName("Java Basics");
    }

    @Test
    void createCourse_Success() {
        when(courseRepository.existsByName(courseDTO.getName())).thenReturn(false);
        when(courseMapper.toEntity(courseDTO)).thenReturn(course);
        when(courseMapper.toDto(course)).thenReturn(courseDTO);

        CourseDTO result = courseService.createCourse(courseDTO);

        assertNotNull(result);
        verify(courseRepository).save(course);
    }

    @Test
    void createCourse_ThrowsDuplicateException() {
        when(courseRepository.existsByName(courseDTO.getName())).thenReturn(true);

        assertThrows(DuplicateCourseException.class, () -> courseService.createCourse(courseDTO));
        verify(courseRepository, never()).save(any());
    }

    @Test
    void updateCourse_Success() {
        Long id = 1L;
        when(courseRepository.findCourseById(id)).thenReturn(Optional.of(course));
        when(courseMapper.toDto(course)).thenReturn(courseDTO);

        CourseDTO result = courseService.updateCourse(id, courseDTO);

        verify(courseMapper).update(courseDTO, course);
        verify(courseRepository).save(course);
        assertNotNull(result);
    }

    @Test
    void deleteCourse_Success() {
        Long id = 1L;
        when(courseRepository.findCourseById(id)).thenReturn(Optional.of(course));

        courseService.deleteCourse(id);

        verify(courseRepository).delete(course);
    }

    @Test
    void deleteCourse_ThrowsNotFoundException() {
        Long id = 99L;
        when(courseRepository.findCourseById(id)).thenReturn(Optional.empty());

        assertThrows(CourseNotFoundException.class, () -> courseService.deleteCourse(id));
    }

    @Test
    void getCourse_Success() {
        Long id = 1L;
        when(courseRepository.findCourseById(id)).thenReturn(Optional.of(course));
        when(courseMapper.toDto(course)).thenReturn(courseDTO);

        CourseDTO result = courseService.getCourse(id);

        assertEquals(courseDTO.getName(), result.getName());
    }

    @Test
    void getAllCourses_ReturnsList() {
        when(courseRepository.findAll()).thenReturn(List.of(course));
        when(courseMapper.toDto(course)).thenReturn(courseDTO);

        List<CourseDTO> result = courseService.getAllCourses();

        assertEquals(1, result.size());
        verify(courseRepository).findAll();
    }
}