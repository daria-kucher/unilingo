package diploma.unilingo.controller;

import diploma.unilingo.dto.CourseDTO;
import diploma.unilingo.entity.Course;
import diploma.unilingo.repository.CourseRepository;
import diploma.unilingo.service.impl.CourseServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private CourseServiceImpl courseService;
    private CourseRepository courseRepository;

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable Long id) {
        var course = courseService.getCourse(id);

        if (course == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(
            @RequestBody CourseDTO request,
            UriComponentsBuilder builder
    ) {

        var courseDto = courseService.createCourse(request);
        var uri = builder.path("/courses/{id}").buildAndExpand(courseDto.getId()).toUri();
        return ResponseEntity.created(uri).body(courseDto);
    }

    // update
    @PutMapping("/{id}")
    public CourseDTO updateCourse(
            @PathVariable(name = "id") Long id,
            @RequestBody CourseDTO request
    ) {

        return courseService.updateCourse(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
