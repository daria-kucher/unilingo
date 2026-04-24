package diploma.unilingo.service.impl;

import diploma.unilingo.dto.ProgressDTO;
import diploma.unilingo.entity.User;
import diploma.unilingo.entity.UserSubSkill;
import diploma.unilingo.repository.UserRepository;
import diploma.unilingo.repository.UserSubSkillRepository;
import diploma.unilingo.service.SkillService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProgressServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserSubSkillRepository userSubSkillRepository;

    @Mock
    private SkillService skillService;

    @InjectMocks
    private ProgressServiceImpl progressService;

    @Test
    void shouldReturnFullProgress() {

        User user = new User();
        user.setId(1L);

        UserSubSkill us1 = new UserSubSkill();
        us1.setpKnowledge(0.5);
        us1.setWeeklyScore(10);

        UserSubSkill us2 = new UserSubSkill();
        us2.setpKnowledge(0.7);
        us2.setWeeklyScore(5);

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        when(userSubSkillRepository.findByUser(user))
                .thenReturn(List.of(us1, us2));

        when(skillService.getUserSkillProgress(1L))
                .thenReturn(List.of());

        ProgressDTO result = progressService.getUserProgress(1L);

        assertEquals(0.6, result.getOverallProgress());
        assertEquals(15, result.getWeeklyProgress());
    }
}