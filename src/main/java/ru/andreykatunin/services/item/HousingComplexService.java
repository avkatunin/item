package ru.andreykatunin.services.item;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.andreykatunin.model.HousingComplex;
import ru.andreykatunin.model.photo.HousingComplexPhoto;
import ru.andreykatunin.repository.HousingComplexRepository;
import ru.andreykatunin.services.EnvironmentData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HousingComplexService {

    private final HousingComplexRepository repository;
    private final EnvironmentData environmentData;

    public HousingComplexService(
            HousingComplexRepository repository,
            EnvironmentData environmentData
    ) {
        this.repository = repository;
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
    public HousingComplex saveHousingComplex(HousingComplex housingComplex, MultipartFile[] files) {
        List<HousingComplexPhoto> housingComplexPhotos = Arrays.stream(files)
                .map(file -> {
                    try {
                        return new HousingComplexPhoto(housingComplex, file.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).collect(Collectors.toList());
        housingComplex.setPhotos(housingComplexPhotos);
        return repository.save(housingComplex);
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
                        .setLink("http://" + environmentData.hostIP + ":" + environmentData.hostPort + "/api/v2/image/" + housingComplexPhoto.getId()));
    }

}
