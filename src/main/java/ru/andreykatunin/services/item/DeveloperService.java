package ru.andreykatunin.services.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.Developer;
import ru.andreykatunin.repository.DeveloperRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloperService {
    private final static Logger logger = LogManager.getLogger(DeveloperService.class);

    private final DeveloperRepository repository;

    public DeveloperService(DeveloperRepository repository) {
        this.repository = repository;
    }

    /**
     * Delete developer object
     * @param id developer
     */
    public void deleteDeveloper(Long id) {
        repository.deleteById(id);
    }

    /**
     * Get developer by id
     * @param id developer
     */
    public Developer getDeveloper(Long id) {
        return repository.findById(id).orElseGet(() -> {
            return null;
        });
    }

    /**
     * Get All developer from DataBase
     * @return List of Developer objects
     */
    public List<Developer> getAll() {
        Iterable<Developer> iterable = repository.findAll();
        List<Developer> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }

    /**
     * Save developer object to repo
     * @param developer object from client
     * @return Developer object from DataBase
     */
    public Developer saveDeveloper(Developer developer) {
        return repository.save(developer);
    }

}
