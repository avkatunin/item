package ru.andreykatunin.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import ru.andreykatunin.model.Developer;
import ru.andreykatunin.services.item.DeveloperService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/developer")
public class DeveloperController {
    private final static Logger logger = LogManager.getLogger(DeveloperService.class);

    private final DeveloperService service;

    public DeveloperController(DeveloperService service) {
        this.service = service;
    }

    @ApiOperation(value = "View a list of all developer", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    List<Developer> all() {
        logger.info("Get all developer");
        return service.getAll();
    }

    @ApiOperation(value = "View developer by id", response = Developer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    Object one(@PathVariable Long id) {
        logger.info("Get developer {}", id);
        return service.getDeveloper(id);
    }

    @ApiOperation(value = "Add new developer", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping
    Developer newOne(@RequestBody Developer developer) {
        logger.info("Add new developer {}", developer.getName());
        return service.saveDeveloper(developer);
    }

    @ApiOperation(value = "Delete developer by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Long id) {
        logger.info("Delete developer {}", id);
        service.deleteDeveloper(id);
    }
}
