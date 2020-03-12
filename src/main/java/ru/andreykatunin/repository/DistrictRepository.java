package ru.andreykatunin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.andreykatunin.model.District;

@Repository
public interface DistrictRepository extends CrudRepository<District, Long> {

}
