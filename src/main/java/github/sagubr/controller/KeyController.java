package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Key;
import github.sagubr.entities.Location;
import github.sagubr.services.KeyService;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;

import java.util.List;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Key", description = "Operações relacionadas a entidade Chaves")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/key")
public class KeyController {

    private final KeyService service;

    @Operation(summary = "Obter todas as chaves")
    @DefaultResponses
    @Get
    public List<Key> findAllKeys() {
        return service.findAll();
    }

    @Operation(summary = "Obter chaves por localização")
    @DefaultResponses
    @Post("/location")
    public List<Key> findByLocation(@Body Location location) {
        return service.findByLocation(location);
    }

}
