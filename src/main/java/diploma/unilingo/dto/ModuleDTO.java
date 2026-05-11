package diploma.unilingo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ModuleDTO {
    private Long id;

    private String name;

    private SubSkillProfileDTO profile;

    private CourseDTO course;

    private boolean completed;

    private TestDTO test;

    private List<SubModuleDTO> subModules;
}
