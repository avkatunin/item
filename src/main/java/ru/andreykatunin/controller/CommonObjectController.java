package ru.andreykatunin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import ru.andreykatunin.model.*;
import ru.andreykatunin.model.search.RealtyRequest;
import ru.andreykatunin.services.dao.SearchDao;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Api(value = "Realty objects Management System")
public class CommonObjectController {
    private final static Logger logger = LogManager.getLogger(CommonObjectController.class);

    private final SearchDao searchDao;

    public CommonObjectController(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    @ApiOperation(value = "Get all realty types", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/realty-type")
    List<RealtyType> realtyTypes() {
        List<RealtyType> realtyTypes = new ArrayList<>();
        realtyTypes.add(new RealtyType(1, "апартаменты"));
        realtyTypes.add(new RealtyType(2, "квартира"));
        realtyTypes.add(new RealtyType(3, "пентхаус"));
        realtyTypes.add(new RealtyType(4, "ритейл"));
        realtyTypes.add(new RealtyType(5, "офис"));
        realtyTypes.add(new RealtyType(6, "особняк"));
        return realtyTypes;
    }


    @ApiOperation(value = "Get all realty object by search model", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/search")
    List<Realty> search(@RequestBody RealtyRequest realtyRequest) {
        logger.info("Search query {}", realtyRequest.toString());
        return searchDao.getRealtyBySearchFromDB(realtyRequest);
    }

}