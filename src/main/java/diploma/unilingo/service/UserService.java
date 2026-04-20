package diploma.unilingo.service;

import diploma.unilingo.dto.UserDTO;
import diploma.unilingo.entity.User;

import java.util.List;

public interface UserService {
    User createUser(UserDTO dto);

    User getUser(Long id);

    List<User> getAllUsers();
}
