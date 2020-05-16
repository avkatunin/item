package ru.andreykatunin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.andreykatunin.model.Realty;

import java.util.List;

@Repository
public interface RealtyRepository extends CrudRepository<Realty, Long> {
    List<Realty> findByPriceLessThanEqual(double priceTo);
    List<Realty> findByPriceGreaterThanEqual(double priceFrom);
}
