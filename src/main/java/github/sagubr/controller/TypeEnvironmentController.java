package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.TypeEnvironment;
import github.sagubr.entities.User;
import github.sagubr.services.TypeEnvironmentService;
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
@Tag(name = "TypeEnvironment", description = "Operações relacionadas a entidade Tipos de Ambiente")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/type-environments")
public class TypeEnvironmentController {

    private final TypeEnvironmentService service;

    @Operation(summary = "Obter todos os tipos de ambiente")
    @DefaultResponses
    @Get
    public List<TypeEnvironment> getAllTypeEnvironments() {
        return service.findAll();
    }
}
