package ru.andreykatunin.services.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.Users;
import ru.andreykatunin.repository.UserRepository;
import ru.andreykatunin.services.dao.EntityDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final static Logger logger = LogManager.getLogger(UserService.class);

    private final UserRepository repository;
    private final EntityDao dao;

    public UserService(UserRepository repository, EntityDao dao) {
        this.repository = repository;
        this.dao = dao;
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
    public Users getUser(Long id) {
        return repository.findById(id).orElseGet(() -> {
            return null;
        });
    }

    public Users getUser(String email) {
        return dao.findByEmail(email);
    }

    /**
     * Get All user from DataBase
     * @return List of User objects
     */
    public List<Users> getAllUser() {
        Iterable<Users> iterable = repository.findAll();
        List<Users> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }

    /**
     * Save user object to repo
     * @param user object from client
     * @return User object from DataBase
     */
    public Users saveUser(Users user) {
        return repository.save(user);
    }

    public Users changeUserRole(Long roleId, Long userId) {
        Users user = getUser(userId);
        if (user == null)
            return null;
        user.setRoleId(roleId.intValue());
        saveUser(user);
        logger.info("User {} role changed to {}", userId, roleId);
        return getUser(userId);
    }
}
