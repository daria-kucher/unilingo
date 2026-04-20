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
import diploma.unilingo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SubSkillRepository subSkillRepository;
    private final UserSubSkillRepository userSubSkillRepository;
    private final LanguageLevelRepository languageLevelRepository;

    public UserServiceImpl(UserRepository userRepository,
                           SubSkillRepository subSkillRepository,
                           UserSubSkillRepository userSubSkillRepository, LanguageLevelRepository languageLevelRepository) {
        this.userRepository = userRepository;
        this.subSkillRepository = subSkillRepository;
        this.userSubSkillRepository = userSubSkillRepository;
        this.languageLevelRepository = languageLevelRepository;
    }


    @Override
    public User createUser(UserDTO dto) {

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());

        // 🔥 отримуємо рівень з БД
        LanguageLevel level = languageLevelRepository.findById(dto.getLevelId())
                .orElseThrow(() -> new RuntimeException("Level not found"));

        user.setLevel(level);

        User savedUser = userRepository.save(user);

        // 🔥 створюємо початкові значення для піднавичок
        List<SubSkill> subSkills = subSkillRepository.findAll();

        for (SubSkill subSkill : subSkills) {

            UserSubSkill us = new UserSubSkill();
            us.setUser(savedUser);
            us.setSubSkill(subSkill);
            us.setpKnowledge(0.2); // стартове знання

            userSubSkillRepository.save(us);
        }

        return savedUser;
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
