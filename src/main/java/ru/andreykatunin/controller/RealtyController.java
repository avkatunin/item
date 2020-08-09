package ru.andreykatunin.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.andreykatunin.model.Realty;
import ru.andreykatunin.model.search.RealtyRequest;
import ru.andreykatunin.services.excel.ExportObjectUtils;
import ru.andreykatunin.services.item.RealtyService;

import java.io.*;
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
    List<Realty> all(@ModelAttribute RealtyRequest realtyRequest) {
        logger.info("Get all realty");
        return service.getAll(realtyRequest);
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

    @ApiOperation(value = "View realty by id", response = Realty.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}/export-excel")
    ResponseEntity exportExcel(@PathVariable Long id) throws IOException {
        logger.info("Get realty {}", id);
        byte[] data = null;
        try {
            data = ExportObjectUtils.toExcel(service.getRealty(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (data == null)
            return ResponseEntity.notFound().build();
        String fileName = "realty-" + id + ".xls";
        InputStream inputStream = new ByteArrayInputStream(data);
        InputStreamResource resource = new InputStreamResource(inputStream);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(inputStream.available())
                .body(resource);
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

