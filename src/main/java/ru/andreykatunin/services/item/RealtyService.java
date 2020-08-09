package ru.andreykatunin.services.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.Realty;
import ru.andreykatunin.model.search.RealtyRequest;
import ru.andreykatunin.repository.RealtyCriteriaRepository;
import ru.andreykatunin.repository.RealtyRepository;
import ru.andreykatunin.services.EnvironmentData;

import java.util.ArrayList;
import java.util.List;

@Service
public class RealtyService {
    private final static Logger logger = LogManager.getLogger(RealtyService.class);

    private final RealtyRepository repository;
    private final RealtyCriteriaRepository criteriaRepository;
    private final EnvironmentData environmentData;

    public RealtyService(
            RealtyRepository repository,
            RealtyCriteriaRepository criteriaRepository,
            EnvironmentData environmentData
    ) {
        this.repository = repository;
        this.criteriaRepository = criteriaRepository;
        this.environmentData = environmentData;
    }

    /**
     * Delete realty object
     * @param id realty
     */
    public void deleteRealty(Long id) {
        repository.deleteById(id);
    }

    /**
     * Get realty by id
     * @param id realty
     */
    public Realty getRealty(Long id) {
        Realty realty = repository.findById(id).orElseGet(() -> {
            return null;
        });
        if (realty != null)
            setImagesLink(realty);
        return realty;
    }

    /**
     * Get All realty from DataBase
     * @return List of Realty objects
     */
    public List<Realty> getAll() {
        Iterable<Realty> iterable = repository.findAll();
        List<Realty> result = new ArrayList<>();
        iterable.forEach(result::add);
        result.forEach(this::setImagesLink);
        return result;
    }

    /**
     * Get All realty from DataBase
     * @return List of Realty objects
     */
    public List<Realty> getAll(RealtyRequest realtyRequest) {
        if (!validateRealtyRequest(realtyRequest)) {
            Iterable<Realty> iterable = repository.findAll();
            List<Realty> result = new ArrayList<>();
            iterable.forEach(result::add);
            result.forEach(this::setImagesLink);
            return result;
        } else {
            return criteriaRepository.findRealtyByFilter(realtyRequest);
        }
    }

    private boolean validateRealtyRequest(RealtyRequest request) {
        return request.getHousingComplexId() > 0
                || request.getDistrictId() > 0
                || request.getDeadline() != null
                || request.getDecoration() != null
                || request.getFloorTo() > 0
                || request.getFloorFrom() > 0
                || request.getAreaFrom() > 0
                || request.getAreaTo() > 0
                || request.getPriceFrom() > 0
                || request.getPriceTo() > 0
                || request.getStatus() != null
                || request.getAmountBedrooms() > 0;
    }

    /**
     * Save realty object to repo
     * @param realty object from client
     * @return Realty object from DataBase
     */
    public Realty saveRealty(Realty realty) {
        return repository.save(realty);
    }

    private void setImagesLink(Realty realty) {
        realty.getBuilding().getHousingComplex().getPhotos()
                .forEach(housingComplexPhoto -> housingComplexPhoto
                        .setUrl("http://" + environmentData.hostIP + ":" + environmentData.hostPort + "/api/v2/image/" + housingComplexPhoto.getId()));
        realty.getPhotos()
                .forEach(realtyPhoto -> realtyPhoto
                        .setUrl("http://" + environmentData.hostIP + ":" + environmentData.hostPort + "/api/v2/image/" + realtyPhoto.getId()));
    }
}
