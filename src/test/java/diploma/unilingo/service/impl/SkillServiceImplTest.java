package diploma.unilingo.service.impl;

import diploma.unilingo.dto.SkillProgressDTO;
import diploma.unilingo.entity.Skill;
import diploma.unilingo.entity.SubSkill;
import diploma.unilingo.entity.User;
import diploma.unilingo.entity.UserSubSkill;
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
class SkillServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserSubSkillRepository userSubSkillRepository;

    @InjectMocks
    private SkillServiceImpl skillService;

    @Test
    void shouldCalculateSkillProgress() {

        User user = new User();

        Skill skill = new Skill();
        skill.setName("Grammar");

        SubSkill sub1 = new SubSkill();
        sub1.setSkill(skill);

        SubSkill sub2 = new SubSkill();
        sub2.setSkill(skill);

        UserSubSkill us1 = new UserSubSkill();
        us1.setSubSkill(sub1);
        us1.setpKnowledge(0.4);

        UserSubSkill us2 = new UserSubSkill();
        us2.setSubSkill(sub2);
        us2.setpKnowledge(0.6);

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        when(userSubSkillRepository.findByUser(user))
                .thenReturn(List.of(us1, us2));

        List<SkillProgressDTO> result =
                skillService.getUserSkillProgress(1L);

        assertEquals(1, result.size());
        assertTrue(result.get(0).getProgress() > 0.4);
    }
}