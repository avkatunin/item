package ru.andreykatunin.services.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.Realty;
import ru.andreykatunin.repository.RealtyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RealtyService {
    private final static Logger logger = LogManager.getLogger(RealtyService.class);

    private final RealtyRepository repository;

    public RealtyService(RealtyRepository repository) {
        this.repository = repository;
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
        return repository.findById(id).orElseGet(() -> {
            return null;
        });
    }

    /**
     * Get All realty from DataBase
     * @return List of Realty objects
     */
    public List<Realty> getAll() {
        Iterable<Realty> iterable = repository.findAll();
        List<Realty> result = new ArrayList<>();
        iterable.forEach(result::add);
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
}
