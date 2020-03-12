package ru.andreykatunin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import ru.andreykatunin.model.*;
import ru.andreykatunin.services.dao.EntityDao;
import ru.andreykatunin.services.item.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Api(value = "Realty objects Management System")
public class ObjectRestController {
    private final static Logger logger = LogManager.getLogger(ObjectRestController.class);

    private final EntityService entityService;
    private final UserService userService;
    private final DeveloperService developerService;
    private final BuildingService buildingService;
    private final DistrictService districtService;
    private final RealtyService realtyService;
    private final EntityDao entityDao;

    public ObjectRestController(
            EntityService entityService,
            UserService userService,
            DeveloperService developerService,
            BuildingService buildingService,
            DistrictService districtService,
            RealtyService realtyService,
            EntityDao entityDao) {
        this.entityService = entityService;
        this.userService = userService;
        this.developerService = developerService;
        this.buildingService = buildingService;
        this.districtService = districtService;
        this.realtyService = realtyService;
        this.entityDao = entityDao;
    }

    @ApiOperation(value = "View a list of all entities", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{entity}")
    public List<?> all(@PathVariable String entity) {
        logger.info("Get all {} objects", entity);

        switch (entity) {
            case "developer":
                return developerService.getAllDeveloper();
            case "building":
                return buildingService.getAllBuilding();
            case "realty":
                return realtyService.getAllRealty();
            case "user":
                return userService.getAllUser();
            case "district":
                return districtService.getAllDistrict();

            default:
                return null;
        }
    }

    @ApiOperation(value = "View entity object by id and entity type", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{entity}/{id}")
    Object one(@PathVariable String entity, @PathVariable Long id) {
        logger.info("Get {} {}", id, entity);
        switch (entity) {
            case "developer":
                return developerService.getDeveloper(id);
            case "building":
                return buildingService.getBuilding(id);
            case "realty":
                return realtyService.getRealty(id);
            case "user":
                return userService.getUser(id);
            case "district":
                return districtService.getDistrict(id);

            default:
                return null;
        }
    }

    @ApiOperation(value = "Add new developer", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/developer")
    Developer newDeveloper(@RequestBody Developer entity) {
        logger.info("Add new developer {}", entity.getName());
        return developerService.saveDeveloper(entity);
    }

    @ApiOperation(value = "Add new building", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/building")
    Building newBuilding(@RequestBody Building entity) {
        logger.info("Add new building {}", entity.getAddress());
        return buildingService.saveBuilding(entity);
    }

    @ApiOperation(value = "Add new realty", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/realty")
    Realty newRealty(@RequestBody Realty entity) {
        logger.info("Add new realty {}", entity.getAddress());
        return realtyService.saveRealty(entity);
    }

    @ApiOperation(value = "Add new district", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/district")
    District newDistrict(@RequestBody District entity) {
        logger.info("Add new district {}", entity.getName());
        return districtService.saveDistrict(entity);
    }

    @ApiOperation(value = "Delete entity object by id and entity type")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/{entity}/{id}")
    void deleteEmployee(@PathVariable String entity, @PathVariable Long id) {
        logger.info("Delete {} {}", id, entity);
        switch (entity) {
            case "developer":
                developerService.deleteDeveloper(id);
                break;
            case "building":
                buildingService.deleteBuilding(id);
                break;
            case "realty":
                realtyService.deleteRealty(id);
                break;
            case "user":
                userService.deleteUser(id);
                break;
            case "district":
                districtService.deleteDistrict(id);
                break;

            default:
                break;

        }
    }

    @ApiOperation(value = "Get all realty object by search model", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/search")
    List<Realty> search(@RequestBody Search search) {
        logger.info("Search query {}", search.toString());
        return entityDao.getRealtyBySearchFromDB(search);
    }

}
