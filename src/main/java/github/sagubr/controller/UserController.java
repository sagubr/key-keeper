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
import lombok.AllArgsConstructor;

import java.util.List;


@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Users", description = "Operações relacionadas a entidade Usuário")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/users")
public class UserController {

    private final UserService service;

    @Operation(summary = "Obter todos os usuários")
    @DefaultResponses
    @Get
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @Operation(summary = "Criar novo usuário")
    @DefaultResponses
    @Post(value = "/save")
    public User save(@Body @Valid UserDto userDTO) {
        return service.save(userDTO);
    }
}