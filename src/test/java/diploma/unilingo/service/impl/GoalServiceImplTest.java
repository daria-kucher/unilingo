package diploma.unilingo.service.impl;

import diploma.unilingo.entity.User;
import diploma.unilingo.entity.UserSubSkill;
import diploma.unilingo.repository.GoalRepository;
import diploma.unilingo.repository.UserRepository;
import diploma.unilingo.repository.UserSubSkillRepository;
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
class GoalServiceImplTest {

    @Mock
    private GoalRepository goalRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserSubSkillRepository userSubSkillRepository;

    @InjectMocks
    private GoalServiceImpl goalService;

    @Test
    void shouldCalculateProgress() {

        User user = new User();

        UserSubSkill s1 = new UserSubSkill();
        s1.setpKnowledge(0.5);

        UserSubSkill s2 = new UserSubSkill();
        s2.setpKnowledge(0.7);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userSubSkillRepository.findByUser(user))
                .thenReturn(List.of(s1, s2));

        double progress = goalService.calculateProgress(1L);

        assertTrue(progress > 0.5);
    }
}