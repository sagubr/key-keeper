package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.User;
import github.sagubr.model.UserDto;
import github.sagubr.services.UserService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
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
    public List<User> findAllUsers() {
        return service.findAll();
    }

    @Operation(summary = "Criar novo usuário")
    @DefaultResponses
    @Post(value = "/save")
    public User addUser(@Body @Valid UserDto userDTO) {
        return service.save(userDTO);
    }

}