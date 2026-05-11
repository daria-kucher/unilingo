package diploma.unilingo.dto;

import lombok.Data;

@Data
public class SubModuleDTO {
    private Long id;

    private String name;

    private String theory;

    private SubSkillProfileDTO profile;

    private ModuleDTO module;

    private boolean completed;

    private TestDTO test;
}
