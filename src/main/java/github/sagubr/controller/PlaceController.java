package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Place;
import github.sagubr.services.PlaceService;
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
@Tag(name = "Places", description = "Operações relacionadas a entidade lugar")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/places")
public class PlaceController {

    private final PlaceService service;

    @Operation(summary = "Obter todos os lugares")
    @DefaultResponses
    @Get
    public List<Place> getAllPlaces() {
        return service.findAll();
    }
}
