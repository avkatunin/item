package ru.andreykatunin.services.item;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.andreykatunin.model.HousingComplex;
import ru.andreykatunin.model.photo.HousingComplexPhoto;
import ru.andreykatunin.repository.HousingComplexRepository;
import ru.andreykatunin.repository.PhotoRepository;
import ru.andreykatunin.services.EnvironmentData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HousingComplexService {

    private final HousingComplexRepository repository;
    private final PhotoRepository photoRepository;
    private final EnvironmentData environmentData;

    public HousingComplexService(
            HousingComplexRepository repository,
            PhotoRepository photoRepository,
            EnvironmentData environmentData
    ) {
        this.repository = repository;
        this.photoRepository = photoRepository;
        this.environmentData = environmentData;
    }

    /**
     * Get All housing complex from DataBase
     * @return List of User objects
     */
    public List<HousingComplex> getAll() {
        Iterable<HousingComplex> iterable = repository.findAll();
        List<HousingComplex> result = new ArrayList<>();
        iterable.forEach(result::add);

        result
                .parallelStream()
                .forEach(this::setImagesLink);
        return result;
    }

    /**
     *
     * @param id
     * @return
     */
    public HousingComplex getHousingComplex(Long id) {
        HousingComplex complex = repository.findById(id).orElse(null);
        if (complex != null)
            setImagesLink(complex);
        return complex;
    }

    /**
     *
     * @param housingComplex
     * @return
     */
    public HousingComplex saveHousingComplex(HousingComplex housingComplex) {
        return repository.save(housingComplex);
    }

    /**
     *
     * @param id
     * @param file
     * @return
     */
    @Transactional
    public HousingComplexPhoto saveHousingComplexPhoto(Long id, MultipartFile file) {
        HousingComplexPhoto photo = null;
        HousingComplex housingComplex = repository.findById(id).orElse(null);
        if (housingComplex == null)
            return null;
        byte[] data;
        String name;
        try {
            data = file.getBytes();
            name = file.getOriginalFilename();
            photo = new HousingComplexPhoto(housingComplex, name, "done", data );
            photo = photoRepository.save(photo);
            photo.setUrl("http://" + environmentData.hostIP + ":" + environmentData.hostPort + "/api/v2/image/" + photo.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return photo;
    }

    /**
     *
     * @param id
     */
    public void deleteHousingComplex(Long id) {
        repository.deleteById(id);
    }

    private void setImagesLink(HousingComplex complex) {
        complex.getPhotos()
                .forEach(housingComplexPhoto -> housingComplexPhoto
                        .setUrl("http://" + environmentData.hostIP + ":" + environmentData.hostPort + "/api/v2/image/" + housingComplexPhoto.getId()));
    }

    //yjkr
}
