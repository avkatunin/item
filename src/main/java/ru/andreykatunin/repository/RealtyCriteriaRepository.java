package ru.andreykatunin.repository;

import org.springframework.stereotype.Repository;
import ru.andreykatunin.model.Realty;
import ru.andreykatunin.model.search.RealtyRequest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RealtyCriteriaRepository {
    private final EntityManager entityManager;

    public RealtyCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Realty> findRealtyByFilter(RealtyRequest request) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Realty> cq = cb.createQuery(Realty.class);

        List<Predicate> predicates = new ArrayList<>();
        Root<Realty> realty = cq.from(Realty.class);
        if (request.getPriceFrom() > 0)
            predicates.add(cb.ge(realty.get("price"), request.getPriceFrom()));
        if (request.getPriceTo() > 0)
            predicates.add(cb.le(realty.get("price"), request.getPriceTo()));
        if (request.getAreaFrom() > 0)
            predicates.add(cb.ge(realty.get("area"), request.getAreaFrom()));
        if (request.getAreaTo() > 0)
            predicates.add(cb.le(realty.get("area"), request.getAreaTo()));
        if (request.getFloorFrom() > 0)
            predicates.add(cb.ge(realty.get("floor"), request.getFloorFrom()));
        if (request.getFloorTo() > 0)
            predicates.add(cb.le(realty.get("floor"), request.getFloorTo()));
        if (request.getStatus() != null)
            predicates.add(cb.equal(realty.get("building").get("status"), request.getStatus().getName()));
        if (request.getDecoration() != null)
            predicates.add(cb.equal(realty.get("building").get("decoration"), request.getDecoration()));
        if (request.getAmountBedrooms() > 0)
            predicates.add(cb.equal(realty.get("amountBedrooms"), request.getAmountBedrooms()));
        if (request.getDeadline() != null)
            predicates.add(cb.equal(realty.get("deadline"), request.getDeadline()));
        if (request.getDistrictId() > 0)
            predicates.add(cb.equal(realty.get("building").get("districtId"), request.getDistrictId()));
        if (request.getHousingComplexId() > 0)
            predicates.add(cb.equal(realty.get("building").get("housingComplexId"), request.getHousingComplexId()));
        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Realty> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
