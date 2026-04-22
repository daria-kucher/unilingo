package diploma.unilingo.service.impl;

import diploma.unilingo.dto.ExerciseResponseDTO;
import diploma.unilingo.entity.*;
import diploma.unilingo.entity.Module;
import diploma.unilingo.repository.ExerciseRepository;
import diploma.unilingo.repository.ModuleRepository;
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
class AdaptiveServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserSubSkillRepository userSubSkillRepository;

    @Mock
    private ExerciseRepository exerciseRepository;

    @Mock
    private ModuleRepository moduleRepository;

    @InjectMocks
    private AdaptiveServiceImpl adaptiveService;

    @Test
    void shouldReturnExerciseForWeakestSubSkill() {

        // 🔹 given
        User user = new User();

        SubSkill weakSub = new SubSkill();

        UserSubSkill s1 = new UserSubSkill();
        s1.setSubSkill(new SubSkill());
        s1.setpKnowledge(0.8);

        UserSubSkill s2 = new UserSubSkill();
        s2.setSubSkill(weakSub);
        s2.setpKnowledge(0.2); // weakest

        Exercise exercise = new Exercise();
        exercise.setId(1L);
        exercise.setQuestion("Q");
        exercise.setCorrectAnswer("A");
        exercise.setWrongAnswers(List.of("B", "C"));

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        when(userSubSkillRepository.findByUser(user))
                .thenReturn(List.of(s1, s2));

        when(exerciseRepository.findBySubSkills(weakSub))
                .thenReturn(List.of(exercise));

        // 🔹 when
        ExerciseResponseDTO result =
                adaptiveService.getNextExercise(1L);

        // 🔹 then
        assertNotNull(result);
        assertEquals("Q", result.getQuestion());
        assertEquals(3, result.getOptions().size());
    }

    @Test
    void shouldReturnModuleForWeakestSkill() {

        User user = new User();

        Skill weakSkill = new Skill();

        SubSkill sub1 = new SubSkill();
        sub1.setSkill(new Skill());

        SubSkill sub2 = new SubSkill();
        sub2.setSkill(weakSkill);

        UserSubSkill us1 = new UserSubSkill();
        us1.setSubSkill(sub1);
        us1.setpKnowledge(0.8);

        UserSubSkill us2 = new UserSubSkill();
        us2.setSubSkill(sub2);
        us2.setpKnowledge(0.2);

        diploma.unilingo.entity.Module module = new Module();

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        when(userSubSkillRepository.findByUser(user))
                .thenReturn(List.of(us1, us2));

        when(moduleRepository.findBySkills(weakSkill))
                .thenReturn(List.of(module));

        diploma.unilingo.entity.Module result = adaptiveService.getNextModule(1L);

        assertNotNull(result);
    }
}