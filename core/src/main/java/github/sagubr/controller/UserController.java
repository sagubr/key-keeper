package github.sagubr.controller;

import github.sagubr.entities.User;
import github.sagubr.services.UserService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

import java.security.Principal;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/users")
public class UserController {

    @Inject
    UserService userService;

    @Produces(MediaType.TEXT_PLAIN)
    @Get
    public String index(Principal principal) {
        return principal.getName();
    }

    @Operation(summary = "Create new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Error"),
    })
    @Post(value = "/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Status(HttpStatus.CREATED)
    public User save(@Body @Valid User user) {
        return userService.save(user);
    }
}
