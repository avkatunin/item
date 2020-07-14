package ru.andreykatunin.services.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.Building;
import ru.andreykatunin.model.HousingComplex;
import ru.andreykatunin.repository.BuildingRepository;
import ru.andreykatunin.services.EnvironmentData;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingService {
    private final static Logger logger = LogManager.getLogger(BuildingService.class);

    private final BuildingRepository repository;
    private final EnvironmentData environmentData;

    public BuildingService(
            BuildingRepository repository,
            EnvironmentData environmentData
    ) {
        this.repository = repository;
        this.environmentData = environmentData;
    }

    /**
     * Delete building object
     * @param id building
     */
    public void deleteBuilding(Long id) {
        repository.deleteById(id);
    }

    /**
     * Get building by id
     * @param id building
     */
    public Building getBuilding(Long id) {
        Building building = repository.findById(id).orElseGet(() -> {
            return null;
        });
        if (building != null)
            setImagesLink(building);
        return building;
    }

    /**
     * Get All building from DataBase
     * @return List of Building objects
     */
    public List<Building> getAll() {
        Iterable<Building> iterable = repository.findAll();
        List<Building> result = new ArrayList<>();
        iterable.forEach(result::add);
        result.forEach(this::setImagesLink);
        return result;
    }

    /**
     * Save building object to repo
     * @param building object from client
     * @return Building object from DataBase
     */
    public Building saveBuilding(Building building) {
        return repository.save(building);
    }

    private void setImagesLink(Building building) {
        building.getHousingComplex().getPhotos()
                .forEach(housingComplexPhoto -> housingComplexPhoto
                        .setUrl("http://" + environmentData.hostIP + ":" + environmentData.hostPort + "/api/v2/image/" + housingComplexPhoto.getId()));
    }
}
