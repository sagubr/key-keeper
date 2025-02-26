package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.LocationType;
import github.sagubr.services.LocationTypeService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "LocationType", description = "Classe referência para Tipos de Ambiente")
@RequiredArgsConstructor
@Controller("/api/location-type")
public class LocationTypeController {

    private final LocationTypeService service;

    @Operation(summary = "Obter todos os registros da classe tipos de ambiente")
    @DefaultResponses
    @Get
    public List<LocationType> findAllLocationType() {
        return service.findAll();
    }

    @Operation(summary = "Criar novo registro na classe tipos de ambiente")
    @DefaultResponses
    @Post(value = "/save")
    public LocationType createLocationType(@Body @Valid LocationType locationType) {
        return service.save(locationType);
    }
}
