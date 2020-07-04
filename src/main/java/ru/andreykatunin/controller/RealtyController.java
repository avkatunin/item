package ru.andreykatunin.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import ru.andreykatunin.model.Realty;
import ru.andreykatunin.services.item.RealtyService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/realty")
public class RealtyController {
    private final static Logger logger = LogManager.getLogger(RealtyService.class);

    private final RealtyService service;

    public RealtyController(RealtyService service) {
        this.service = service;
    }

    @ApiOperation(value = "View a list of all realty", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    List<Realty> all() {
        logger.info("Get all realty");
        return service.getAll();
    }

    @ApiOperation(value = "View realty by id", response = Realty.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    Object one(@PathVariable Long id) {
        logger.info("Get realty {}", id);
        return service.getRealty(id);
    }

    @ApiOperation(value = "Add new realty", response = Realty.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping
    Realty newOne(@RequestBody Realty realty) {
        logger.info("Add new realty {}", realty.getAddress());
        return service.saveRealty(realty);
    }

    @ApiOperation(value = "Delete realty by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Long id) {
        logger.info("Delete realty {}", id);
        service.deleteRealty(id);
    }
}

