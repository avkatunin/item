package ru.andreykatunin.exception;


import ru.andreykatunin.model.photo.Photo;

import java.util.function.Supplier;

public class ImageNotFoundException extends Exception implements Supplier<Photo> {
    private Long id;

    public ImageNotFoundException(String s, Long id) {
        super(s);
        this.id = id;
    }

    @Override
    public Photo get() {
        return null;
    }
}
