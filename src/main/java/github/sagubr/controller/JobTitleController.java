package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.JobTitle;
import github.sagubr.services.JobTitleService;
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
@Tag(name = "JobTitle", description = "Operações relacionadas a entidade cargo")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/positions")
public class JobTitleController {

    private final JobTitleService service;

    @Operation(summary = "Obter todos os cargos")
    @DefaultResponses
    @Get
    public List<JobTitle> getAllPositions() {
        return service.findAll();
    }
}
