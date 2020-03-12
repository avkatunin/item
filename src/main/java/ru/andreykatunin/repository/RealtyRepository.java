package ru.andreykatunin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.andreykatunin.model.Realty;

@Repository
public interface RealtyRepository extends CrudRepository<Realty, Long> {

}
