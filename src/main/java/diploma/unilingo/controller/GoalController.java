package diploma.unilingo.controller;

import diploma.unilingo.dto.GoalDTO;
import diploma.unilingo.service.GoalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@AllArgsConstructor
@RequestMapping("/goals")
public class GoalController {
    private final GoalService goalService;

    @GetMapping("/{id}")
    public ResponseEntity<GoalDTO> getGoal(@PathVariable Long id) {
        var goal = goalService.getGoal(id);

        if (goal == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(goal);
    }

    @PostMapping
    public ResponseEntity<GoalDTO> createGoal(
            @RequestBody GoalDTO request,
            UriComponentsBuilder builder
    ) {
        var goalDto = goalService.createGoal(request);
        var uri = builder.path("/goals/{id}").buildAndExpand(goalDto.getId()).toUri();
        return ResponseEntity.created(uri).body(goalDto);
    }
}
