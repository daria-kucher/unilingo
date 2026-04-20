package diploma.unilingo.controller;

import diploma.unilingo.dto.GoalDTO;
import diploma.unilingo.entity.Goal;
import diploma.unilingo.service.GoalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goals")
public class GoalController {
    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping("/{userId}")
    public Goal setGoal(@PathVariable Long userId,
                        @RequestBody GoalDTO dto) {
        return goalService.createOrUpdateGoal(userId, dto);
    }

    @GetMapping("/{userId}")
    public Goal getGoal(@PathVariable Long userId) {
        return goalService.getUserGoal(userId);
    }
}
