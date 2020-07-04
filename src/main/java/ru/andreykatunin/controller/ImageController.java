package ru.andreykatunin.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.andreykatunin.exception.ImageNotFoundException;
import ru.andreykatunin.model.photo.Photo;
import ru.andreykatunin.repository.PhotoRepository;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@CrossOrigin
@RestController
@RequestMapping("/api/v2/image")
public class ImageController {

    private final PhotoRepository repository;

    public ImageController(PhotoRepository repository) {
        this.repository = repository;
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    byte[] getImageWithMediaType(@PathVariable Long id) throws IOException {
        Photo photo = repository.findById(id).orElse(null);
        if (photo == null || photo.getData() == null)
            throw new IOException("");
        return photo.getData();
    }

    @GetMapping(value = "/host")
    String getHost1() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }

}
