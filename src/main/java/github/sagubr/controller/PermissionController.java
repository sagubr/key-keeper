package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Permission;
import github.sagubr.entities.Requester;
import github.sagubr.services.PermissionService;
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
import lombok.RequiredArgsConstructor;

import java.util.List;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Permission", description = "Operações relacionadas a entidade Permissão")
@RequiredArgsConstructor
@Controller("/api/permissions")
public class PermissionController {

    private final PermissionService service;

    @Operation(summary = "Obter todas as permissões")
    @DefaultResponses
    @Get
    public List<Permission> findAllPermissions() {
        return service.findAll();
    }

    @Operation(summary = "Obter todas as permissões por solicitante")
    @DefaultResponses
    @Post("/requester")
    public List<Permission> findByRequester(@Body @Valid Requester requester) {
        return service.findByRequester(requester);
    }

    @Operation(summary = "Criar nova instalação")
    @DefaultResponses
    @Post(value = "/save")
    public Permission addPermission(@Body @Valid Permission permission) {
        return service.save(permission);
    }

}
