package ru.andreykatunin.services.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.District;
import ru.andreykatunin.repository.DistrictRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictService {
    private final static Logger logger = LogManager.getLogger(DistrictService.class);

    private final DistrictRepository repository;

    public DistrictService(DistrictRepository repository) {
        this.repository = repository;
    }

    /**
     * Delete district object
     * @param id district
     */
    public void deleteDistrict(Long id) {
        repository.deleteById(id);
    }

    /**
     * Get district by id
     * @param id district
     */
    public District getDistrict(Long id) {
        return repository.findById(id).orElseGet(() -> {
            return null;
        });
    }

    /**
     * Get All district from DataBase
     * @return List of District objects
     */
    public List<District> getAllDistrict() {
        Iterable<District> iterable = repository.findAll();
        List<District> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }

    /**
     * Save district object to repo
     * @param district object from client
     * @return District object from DataBase
     */
    public District saveDistrict(District district) {
        return repository.save(district);
    }
}
