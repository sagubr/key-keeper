package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Key;
import github.sagubr.services.KeyService;
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
@Tag(name = "Keys", description = "Operações relacionadas a entidade Chaves")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/keys")
public class KeyController {

    private final KeyService service;

    @Operation(summary = "Obter todas as chaves")
    @DefaultResponses
    @Get
    public List<Key> getAllKeys() {
        return service.findAll();
    }
}
