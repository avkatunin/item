package ru.andreykatunin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.andreykatunin.model.Developer;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Long> {

}
