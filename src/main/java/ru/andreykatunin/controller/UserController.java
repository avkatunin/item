package ru.andreykatunin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import ru.andreykatunin.model.Users;
import ru.andreykatunin.model.mail.UserAccess;
import ru.andreykatunin.repository.UserAccessRepository;
import ru.andreykatunin.services.item.UserService;
import ru.andreykatunin.services.mail.EmailServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
@Api(value = "User controller")
public class UserController {
    private final static Logger logger = LogManager.getLogger(UserController.class);

    private final Environment env;
    private final UserService service;
    private final UserAccessRepository repository;
    private final EmailServiceImpl emailService;

    public UserController(
            Environment env,
            UserService service,
            UserAccessRepository repository,
            EmailServiceImpl emailService
    ) {
        this.env = env;
        this.service = service;
        this.repository = repository;
        this.emailService = emailService;
    }

    @ApiOperation(value = "Get current jsessionid user", response = Users.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/current-user")
    public Users currentUSer() {
        Users user = null;

        if (Arrays.asList(env.getActiveProfiles()).contains("local")) {
            return service.getUser("nana@pochta.ru");
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            String email = null;
            try {
                email = auth.getName();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            user = service.getUser(email);
        }

        return user;
    }

    @ApiOperation(value = "Add new user", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping
    ResponseEntity<?> newUser(@RequestBody Users entity) {
        System.out.println("New user");
        entity.setRoleId(3);
        if (!repository.check(entity.getEmail(), entity.getSecretCode())) {
            return new ResponseEntity<>("Неверный код регистарции", HttpStatus.CONFLICT);
        }
        Users user = service.saveUser(entity);
        if (user == null)
            return new ResponseEntity<>("Пользователь с таким e-mail уже существует", HttpStatus.CONFLICT);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    Users changeUserRole(
            @RequestBody Map<String, Object> updates,
            @PathVariable(name = "id") Long id
    ) {
        Long roleId = new Long((Integer) updates.get("roleId"));
        logger.info("Prepare change user {} role to {}", id, roleId);
        return service.changeUserRole(roleId, id);
    }

    @PostMapping("/invite")
    public String inviteUser(@RequestBody UserAccess access) {
        repository.save(access);
        emailService.sendSimpleMessage(access.getEmail(),"Приглашение на регистарцию", access.getUuid());
        return "ok";
    }

    @ApiOperation(value = "Delete user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Long id) {
        logger.info("Delete user {}", id);
        service.deleteUser(id);
    }

    @ApiOperation(value = "View a list of all district", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping
    List<Users> all() {
        logger.info("Get all district");
        return service.getAll();
    }

    @ApiOperation(value = "View district by id", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    Object one(@PathVariable Long id) {
        logger.info("Get district {}", id);
        return service.getUser(id);
    }
}
