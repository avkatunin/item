package ru.andreykatunin.services.item;

import org.springframework.stereotype.Service;
import ru.andreykatunin.model.HousingComplex;
import ru.andreykatunin.model.Users;
import ru.andreykatunin.repository.HousingComplexRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class HousingComplexService {

    private final HousingComplexRepository repository;

    public HousingComplexService(HousingComplexRepository repository) {
        this.repository = repository;
    }

    /**
     * Get All housing complex from DataBase
     * @return List of User objects
     */
    public List<HousingComplex> getAll() {
        Iterable<HousingComplex> iterable = repository.findAll();
        List<HousingComplex> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }
}
