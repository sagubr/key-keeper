package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Permission;
import github.sagubr.services.PermissionService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;

import java.util.List;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Permissions", description = "Operações relacionadas a entidade Permissão")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/permissions")
public class PermissionController {

    private final PermissionService service;

    @Operation(summary = "Obter todas as permissões")
    @DefaultResponses
    @Get
    public List<Permission> getAllPermissions() {
        return service.findAll();
    }
}