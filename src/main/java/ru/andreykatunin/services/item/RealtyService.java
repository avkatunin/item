package ru.andreykatunin.services.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.Realty;
import ru.andreykatunin.repository.RealtyRepository;
import ru.andreykatunin.services.EnvironmentData;

import java.util.ArrayList;
import java.util.List;

@Service
public class RealtyService {
    private final static Logger logger = LogManager.getLogger(RealtyService.class);

    private final RealtyRepository repository;
    private final EnvironmentData environmentData;

    public RealtyService(
            RealtyRepository repository,
            EnvironmentData environmentData
    ) {
        this.repository = repository;
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
