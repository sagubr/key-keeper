package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.JobTitle;
import github.sagubr.entities.Key;
import github.sagubr.entities.Location;
import github.sagubr.services.KeyService;
import io.micronaut.http.annotation.*;
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
@Tag(name = "Key", description = "Operações relacionadas a entidade Chaves")
@RequiredArgsConstructor
@Controller("/api/key")
public class KeyController {

    private final KeyService service;

    @Operation(summary = "Obter todas as chaves")
    @DefaultResponses
    @Get
    public List<Key> findAllKeys() {
        return service.findAll();
    }

    //TODO: simplficar para enviar apenas UUID
    @Operation(summary = "Obter chaves por localização")
    @DefaultResponses
    @Post("/location")
    public List<Key> findByLocation(@Body @Valid Location location) {
        return service.findByLocation(location);
    }

    @Operation(summary = "Criar novo cargo")
    @DefaultResponses
    @Post(value = "/save")
    public Key addKey(@Body @Valid Key key) {
        return service.save(key);
    }

    @Operation(summary = "Atualizar cargo existente")
    @DefaultResponses
    @Post(value = "/update")
    public Key updateKey(@Body @Valid Key key) {
        return service.update(key);
    }

}
