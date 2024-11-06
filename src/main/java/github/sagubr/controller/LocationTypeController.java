package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.LocationType;
import github.sagubr.services.LocationTypeService;
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
@Tag(name = "LocationType", description = "Operações relacionadas a entidade Tipos de Ambiente")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/location-type")
public class LocationTypeController {

    private final LocationTypeService service;

    @Operation(summary = "Obter todos os tipos de ambiente")
    @DefaultResponses
    @Get
    public List<LocationType> getAllTypeEnvironments() {
        return service.findAll();
    }
}
