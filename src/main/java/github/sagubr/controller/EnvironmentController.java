package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Environment;
import github.sagubr.services.EnvironmentService;
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
@Tag(name = "Environment", description = "Operações relacionadas a entidade Ambiente")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/environment")
public class EnvironmentController {

    private final EnvironmentService service;

    @Operation(summary = "Obter todos os ambientes")
    @DefaultResponses
    @Get
    public List<Environment> getAllEnvironments() {
        return service.findAll();
    }
}
