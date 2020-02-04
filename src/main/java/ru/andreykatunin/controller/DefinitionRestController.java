package ru.andreykatunin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.andreykatunin.model.*;

@RestController
@RequestMapping("/api/meta")
public class DefinitionRestController {

    public DefinitionRestController() {
    }

    @GetMapping(value = "/user")
    public User userDefinition() {
        return new User();
    }

    @GetMapping(value = "/building")
    public Building buildingDefinition() {
        return new Building();
    }

    @GetMapping(value = "/district")
    public District districtDefinition() {
        return new District();
    }

    @GetMapping(value = "/developer")
    public Developer developerDefinition() {
        return new Developer();
    }

    @GetMapping(value = "/realty")
    public Realty realtyDefinition() {
        return new Realty();
    }
}
