package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.User;
import github.sagubr.entities.dtos.UserDto;
import github.sagubr.services.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

import java.util.List;


@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Users", description = "Operations related to user management")
@Controller("/api/users")
public class UserController {

    private final UserService service;

    @Inject
    public UserController(UserService service) {
        this.service = service;
    }

    @Operation(summary = "Get All Users")
    @DefaultResponses
    @Get
    @Produces(MediaType.APPLICATION_JSON)
    @Status(HttpStatus.ACCEPTED)
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @Operation(summary = "Create new user")
    @DefaultResponses
    @Post(value = "/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Status(HttpStatus.CREATED)
    public User save(@Body @Valid UserDto userDTO) {
        return service.save(userDTO);
    }
}