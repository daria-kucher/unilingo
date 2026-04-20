package diploma.unilingo.controller;

import diploma.unilingo.dto.AttemptRequestDTO;
import diploma.unilingo.dto.AttemptResponseDTO;
import diploma.unilingo.service.AttemptService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attempts")
public class AttemptController {
    private final AttemptService attemptService;

    public AttemptController(AttemptService attemptService) {
        this.attemptService = attemptService;
    }

    @PostMapping
    public AttemptResponseDTO submit(@RequestBody AttemptRequestDTO request) {
        return attemptService.submitAttempt(request);
    }
}
