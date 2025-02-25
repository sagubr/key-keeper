package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Requester;
import github.sagubr.services.RequesterService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Requester", description = "Classe referência para Solicitantes")
@RequiredArgsConstructor
@Controller("/api/requesters")
public class RequesterController {

    private final RequesterService service;

    @Operation(summary = "Obter todos os registros da classe solicitantes")
    @DefaultResponses
    @Get
    public List<Requester> findAllRequesters() {
        return service.findAll();
    }

    @Operation(summary = "Obter todos os registros da classe solicitantes filtrados por respinsável=true")
    @DefaultResponses
    @Get("/responsible")
    public List<Requester> findAllRequesterByResponsibleTrue() {
        return service.findAllByResponsibleTrue();
    }

    @Operation(summary = "Criar novo registro na classe solicitantes")
    @DefaultResponses
    @Post(value = "/save")
    public Requester createRequester(@Body @Valid Requester requester) {
        return service.save(requester);
    }

}
