package ru.andreykatunin.repository;

import org.springframework.stereotype.Repository;
import ru.andreykatunin.model.mail.UserAccess;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserAccessRepository {

    private final Map<String, UserAccess> repo;

    public UserAccessRepository() {
        this.repo = new HashMap<>();
    }

    public void save(UserAccess access) {
        access.setUuid(UUID.randomUUID().toString());
        repo.put(access.getEmail(), access);
    }

    public boolean check(String email, String uuid) {
        UserAccess access = repo.get(email);
        if (access == null) return false;
        return access.getUuid().equals(uuid);
    }

    public void remove(String email) {
        repo.remove(email);
    }

}
