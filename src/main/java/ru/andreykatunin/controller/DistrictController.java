package ru.andreykatunin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.andreykatunin.model.District;
import ru.andreykatunin.repository.DistrictRepository;

import java.util.List;

@RestController
public class DistrictController {

    private final DistrictRepository repository;

    public DistrictController(DistrictRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/repo")
    List<District> getAll() {
        return (List<District>) repository.findAll();
    }
}
