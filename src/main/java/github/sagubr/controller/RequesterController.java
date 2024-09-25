package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Requester;
import github.sagubr.services.RequesterService;
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
@Tag(name = "Requesters", description = "Operações relacionadas a entidade solicitantes")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/requesters")
public class RequesterController {

    private final RequesterService service;

    @Operation(summary = "Obter todos os solicitantes")
    @DefaultResponses
    @Get
    public List<Requester> getAllRequesters() {
        return service.findAll();
    }
}
