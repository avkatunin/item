package ru.andreykatunin.services.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.User;
import ru.andreykatunin.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final static Logger logger = LogManager.getLogger(UserService.class);

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Delete user object
     * @param id user
     */
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    /**
     * Get user by id
     * @param id user
     */
    public User getUser(Long id) {
        return repository.findById(id).orElseGet(() -> {
            return null;
        });
    }

    public User getUser(String email) {
        return repository.findByEmail(email).orElseGet(() -> {
            return null;
        });
    }

    /**
     * Get All user from DataBase
     * @return List of User objects
     */
    public List<User> getAllUser() {
        Iterable<User> iterable = repository.findAll();
        List<User> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }

    /**
     * Save user object to repo
     * @param user object from client
     * @return User object from DataBase
     */
    public User saveUser(User user) {
        return repository.save(user);
    }

    public User changeUserRole(Long roleId, Long userId) {
        User user = getUser(userId);
        if (user == null)
            return null;
        user.setRoleId(roleId.intValue());
        saveUser(user);
        logger.info("User {} role changed to {}", userId, roleId);
        return getUser(userId);
    }
}
