package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Location;
import github.sagubr.services.LocationService;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Location", description = "Operações relacionadas a entidade Localização")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/location")
public class LocationController {

    private final LocationService service;

    @Operation(summary = "Obter todas as localizações")
    @DefaultResponses
    @Get
    public List<Location> findAllLocations() {
        return service.findAll();
    }

    @Operation(summary = "Obter detalhes de uma localização por ID")
    @DefaultResponses
    @Get("/{id}")
    public Location findByIdLocation(@PathVariable UUID id) {
        return service.findById(id);
    }

    @Operation(summary = "Criar nova localização")
    @DefaultResponses
    @Post(value = "/save")
    public Location addLocation(@Body @Valid Location location) {
        System.out.println(location.toString());
        return service.save(location);
    }

}
