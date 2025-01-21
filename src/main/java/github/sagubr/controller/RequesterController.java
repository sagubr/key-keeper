package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Facility;
import github.sagubr.entities.Requester;
import github.sagubr.services.FacilityService;
import github.sagubr.services.RequesterService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Requester", description = "Operações relacionadas a entidade solicitantes")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/requesters")
public class RequesterController {

    private final RequesterService service;

    @Operation(summary = "Obter todos os solicitantes")
    @DefaultResponses
    @Get
    public List<Requester> findAllRequesters() {
        return service.findAll();
    }

    @Operation(summary = "Criar novo solicitante")
    @DefaultResponses
    @Post(value = "/save")
    public Requester addRequester(@Body @Valid Requester requester) {
        return service.save(requester);
    }

}
