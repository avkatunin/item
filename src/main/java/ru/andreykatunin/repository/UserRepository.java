package ru.andreykatunin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.andreykatunin.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
}
