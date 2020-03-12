package ru.andreykatunin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.andreykatunin.model.Building;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Long> {

}
