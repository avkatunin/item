package ru.andreykatunin.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.andreykatunin.model.HousingComplex;
import ru.andreykatunin.model.photo.HousingComplexPhoto;
import ru.andreykatunin.services.item.HousingComplexService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/housing-complex")
public class HousingComplexController {
    private final static Logger logger = LogManager.getLogger(CommonObjectController.class);

    private final HousingComplexService service;

    public HousingComplexController(HousingComplexService service) {
        this.service = service;
    }

    @ApiOperation(value = "View a list of all housing complexes", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    List<HousingComplex> all() {
        logger.info("Get all housing complex");
        return service.getAll();
    }

    @ApiOperation(value = "View housing complex by id", response = HousingComplex.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    Object one(@PathVariable Long id) {
        logger.info("Get housing complex {}", id);
        return service.getHousingComplex(id);
    }

    @ApiOperation(value = "Add new housing complex", response = HousingComplex.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping
    HousingComplex newOne(@RequestBody HousingComplex housingComplex) {
        logger.info("New housing complex {}", housingComplex.getName());
        return service.saveHousingComplex(housingComplex);
    }

    @ApiOperation(value = "Add new housing complex", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping(value = "/{id}/photos")
    HousingComplexPhoto uploadFiles(
            @RequestParam("file") MultipartFile file,
            @PathVariable Long id) {
        logger.info("New housing complex photo id: {} name: {}", id, file.getOriginalFilename());
        return service.saveHousingComplexPhoto(id, file);
    }

    @ApiOperation(value = "Delete housing complex by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Long id) {
        logger.info("Delete housing complex {}", id);
        service.deleteHousingComplex(id);
    }
}