package ru.andreykatunin.services.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.Building;
import ru.andreykatunin.repository.BuildingRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingService {
    private final static Logger logger = LogManager.getLogger(BuildingService.class);

    private final BuildingRepository repository;

    public BuildingService(BuildingRepository repository) {
        this.repository = repository;
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
        return repository.findById(id).orElseGet(() -> {
            return null;
        });
    }

    /**
     * Get All building from DataBase
     * @return List of Building objects
     */
    public List<Building> getAll() {
        Iterable<Building> iterable = repository.findAll();
        List<Building> result = new ArrayList<>();
        iterable.forEach(result::add);
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
}
