package ru.andreykatunin.controller;

import org.springframework.web.bind.annotation.*;
import ru.andreykatunin.model.Flat;
import ru.andreykatunin.services.item.FlatService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlatRestController {

    private final FlatService flatService;

    public FlatRestController(FlatService flatService) {
        this.flatService = flatService;
    }

    @PostMapping(value = "/get", produces="application/json", consumes="application/json")
    public List<Flat> getFlats(@RequestBody Flat item) {
        return flatService.getFlats(item);
    }

    @GetMapping(value = "/ok")
    public String getOk() {
        return "ok";
    }

    @GetMapping(value = "/info")
    public String info() {
        return "ok";
    }
}
