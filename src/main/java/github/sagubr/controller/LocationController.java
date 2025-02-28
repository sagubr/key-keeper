package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Location;
import github.sagubr.services.LocationService;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Location", description = "Classe referência para Localização")
@RequiredArgsConstructor
@Controller("/api/location")
public class LocationController {

    private final LocationService service;

    @Operation(summary = "Obter todos os registros da classe localização")
    @DefaultResponses
    @Get
    public List<Location> findAllLocation() {
        return service.findAll();
    }

    @Operation(summary = "Obter todos os registros da classe localização filtrados por permissionId")
    @DefaultResponses
    @Get("/{id}")
    public Location findByIdLocation(@PathVariable UUID id) {
        return service.findById(id);
    }

    @Operation(summary = "Criar novo registro na classe localização")
    @DefaultResponses
    @Post(value = "/save")
    public Location createLocation(@Body @Valid Location location) {
        return service.save(location);
    }

    @Operation(summary = "Obter todos os registros da classe localização que não sejam restritos e que sejam publicos")
    @DefaultResponses
    @Get(value = "/public")
    public List<Location> findByRestrictedFalseAndPublicTrue() {
        return service.findByRestrictedFalseAndPublicTrue();
    }

    @Operation(summary = "Obter todos os registros da classe localização que não sejam restritos e que não sejam publicos")
    @DefaultResponses
    @Get(value = "/not-restricted")
    public List<Location> findByRestrictedFalseAndPublicFalse() {
        return service.findByRestrictedFalseAndPublicFalse();
    }

    @Operation(summary = "Obter todos os registros da classe localização filtrados por requesterId")
    @DefaultResponses
    @Get("/responsible/{requesterId}")
    public List<Location> findByResponsiblesId(@PathVariable UUID requesterId) {
        return service.findByResponsiblesId(requesterId);
    }

}
