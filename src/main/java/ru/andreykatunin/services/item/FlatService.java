package ru.andreykatunin.services.item;

import org.springframework.stereotype.Service;
import ru.andreykatunin.model.Flat;
import ru.andreykatunin.services.dao.FlatDao;

import java.util.List;

@Service
public class FlatService {

    private final FlatDao flatDao;

    public FlatService(FlatDao flatDao) {
        this.flatDao = flatDao;
    }

    public List<Flat> getFlats(Flat flat) {
        return flatDao.getFlatsFromDB(flat);
    }
}
