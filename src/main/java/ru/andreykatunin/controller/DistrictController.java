package ru.andreykatunin.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import ru.andreykatunin.model.District;
import ru.andreykatunin.services.item.DistrictService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/district")
public class DistrictController {
    private final static Logger logger = LogManager.getLogger(DistrictService.class);

    private final DistrictService service;

    public DistrictController(DistrictService service) {
        this.service = service;
    }

    @ApiOperation(value = "View a list of all district", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    List<District> all() {
        logger.info("Get all district");
        return service.getAll();
    }

    @ApiOperation(value = "View district by id", response = District.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    Object one(@PathVariable Long id) {
        logger.info("Get district {}", id);
        return service.getDistrict(id);
    }

    @ApiOperation(value = "Add new district", response = District.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping
    District newOne(@RequestBody District district) {
        logger.info("Add new district {}", district.getName());
        return service.saveDistrict(district);
    }

    @ApiOperation(value = "Delete district by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Long id) {
        logger.info("Delete district {}", id);
        service.deleteDistrict(id);
    }
}


