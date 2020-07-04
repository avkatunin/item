package ru.andreykatunin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.andreykatunin.model.photo.Photo;

@Repository
public interface PhotoRepository extends CrudRepository<Photo, Long> {
}
