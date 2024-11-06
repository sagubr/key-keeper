package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Location;
import github.sagubr.services.LocationService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Location", description = "Operações relacionadas à entidade Localização")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/location")
public class LocationController {

    private final LocationService service;

    @Operation(summary = "Obter todos os ambientes")
    @DefaultResponses
    @Get
    public List<Location> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Criar um novo ambiente")
    @DefaultResponses
    @Post
    public HttpResponse<Location> createEnvironment(@Body Location location) {
        Location createdLocation = service.save(location);
        return HttpResponse.created(createdLocation);
    }

    @Operation(summary = "Obter detalhes de um ambiente por ID")
    @DefaultResponses
    @Get("/{id}")
    public Optional<Location> getEnvironmentById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @Operation(summary = "Remover um ambiente por ID")
    @DefaultResponses
    @Delete("/{id}")
    public HttpResponse<Void> deleteEnvironment(@PathVariable UUID id) {
        Optional<Location> existingEnvironment = service.findById(id);
        if (existingEnvironment.isPresent()) {
            service.deleteById(id);
            return HttpResponse.noContent();
        }
        return HttpResponse.notFound();

    }
}
