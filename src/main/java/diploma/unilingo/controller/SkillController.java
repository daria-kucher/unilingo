package diploma.unilingo.controller;

import diploma.unilingo.dto.SkillProgressDTO;
import diploma.unilingo.service.SkillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/user/{userId}")
    public List<SkillProgressDTO> getUserSkills(@PathVariable Long userId) {
        return skillService.getUserSkillProgress(userId);
    }
}
