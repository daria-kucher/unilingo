package diploma.unilingo.service.impl;

import diploma.unilingo.dto.UserDTO;
import diploma.unilingo.entity.LanguageLevel;
import diploma.unilingo.entity.SubSkill;
import diploma.unilingo.entity.User;
import diploma.unilingo.entity.UserSubSkill;
import diploma.unilingo.repository.LanguageLevelRepository;
import diploma.unilingo.repository.SubSkillRepository;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private SubSkillRepository subSkillRepository;

    @Mock
    private UserSubSkillRepository userSubSkillRepository;

    @Mock
    private LanguageLevelRepository languageLevelRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void shouldCreateUserWithSubSkillsAndLevel() {

        // 🔹 given
        UserDTO dto = new UserDTO();
        dto.setUsername("testUser");
        dto.setPassword("123");
        dto.setLevelId(1L);

        LanguageLevel level = new LanguageLevel();
        level.setId(1L);
        level.setName("A1");

        SubSkill s1 = new SubSkill();
        SubSkill s2 = new SubSkill();

        List<SubSkill> subSkills = List.of(s1, s2);

        // моки
        when(languageLevelRepository.findById(1L))
                .thenReturn(Optional.of(level));

        when(subSkillRepository.findAll())
                .thenReturn(subSkills);

        when(userRepository.save(any(User.class)))
                .thenAnswer(inv -> inv.getArgument(0));

        when(userSubSkillRepository.save(any(UserSubSkill.class)))
                .thenAnswer(inv -> inv.getArgument(0));

        // 🔹 when
        User result = userService.createUser(dto);

        // 🔹 then
        assertNotNull(result);
        assertEquals("testUser", result.getUsername());
        assertEquals(level, result.getLevel());

        // перевіряємо що створились піднавички
        verify(userSubSkillRepository, times(2))
                .save(any(UserSubSkill.class));
    }
}