package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Location;
import github.sagubr.entities.Permission;
import github.sagubr.entities.Requester;
import github.sagubr.models.PermissionLocationSummaryDto;
import github.sagubr.services.PermissionService;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Permission", description = "Operações relacionadas a entidade Permissão")
@RequiredArgsConstructor
@Controller("/api/permissions")
public class PermissionController {

    private final PermissionService service;

    @Operation(summary = "Obter todas as permissões")
    @DefaultResponses
    @Get
    public List<Permission> findAllPermission() {
        return service.findAll();
    }

    @Operation(summary = "Obter permissão por ID")
    @DefaultResponses
    @Get("/{id}")
    public Permission findByIdPermission(@PathVariable @NotBlank @NotNull UUID id) {
        return service.findById(id);
    }

    @Operation(summary = "Obter todas as permissões por solicitantes")
    @DefaultResponses
    @Get("/requester/{id}")
    public List<PermissionLocationSummaryDto> findByRequestersIdAndEndDateTimeAfter(@PathVariable @NotBlank @NotNull UUID id) {
        return service.findByRequestersIdAndEndDateTimeAfterAndActiveTrue(id, ZonedDateTime.now());
    }

    @Operation(summary = "Criar uma nova permissão")
    @DefaultResponses
    @Post("/save")
    public Permission createPermission(@Body @Valid Permission permission) {
        return service.save(permission);
    }

    @Operation(summary = "Atualizar uma permissão existente")
    @DefaultResponses
    @Put("/update")
    public Permission updatePermission(@Body @Valid Permission permission) {
        return service.update(permission);
    }

    @Operation(summary = "Excluir permissão por ID")
    @DefaultResponses
    @Delete("/{id}")
    public void deleteByIdPermission(@PathVariable @NotNull UUID id) {
        service.deleteById(id);
    }

    @Operation(summary = "Excluir uma permissão")
    @DefaultResponses
    @Delete("/delete")
    public void deletePermission(@Body @Valid Permission permission) {
        service.delete(permission);
    }

}
