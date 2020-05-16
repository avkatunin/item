package ru.andreykatunin.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.andreykatunin.model.HousingComplex;

@Repository
public interface HousingComplexRepository extends CrudRepository<HousingComplex, Long> {

}