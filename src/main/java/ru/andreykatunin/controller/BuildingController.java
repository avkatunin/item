package ru.andreykatunin.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import ru.andreykatunin.model.Building;
import ru.andreykatunin.model.Developer;
import ru.andreykatunin.services.item.BuildingService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/building")
public class BuildingController {
    private final static Logger logger = LogManager.getLogger(BuildingService.class);

    private final BuildingService service;

    public BuildingController(BuildingService service) {
        this.service = service;
    }

    @ApiOperation(value = "View a list of all building", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    List<Building> all() {
        logger.info("Get all building");
        return service.getAll();
    }

    @ApiOperation(value = "View building by id", response = Building.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    Object one(@PathVariable Long id) {
        logger.info("Get building {}", id);
        return service.getBuilding(id);
    }

    @ApiOperation(value = "Add new building", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping
    Building newOne(@RequestBody Building building) {
        logger.info("Add new building {}", building.getName());
        return service.saveBuilding(building);
    }

    @ApiOperation(value = "Delete building by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Long id) {
        logger.info("Delete building {}", id);
        service.deleteBuilding(id);
    }
}

