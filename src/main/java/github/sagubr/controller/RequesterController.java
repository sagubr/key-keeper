package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Requester;
import github.sagubr.services.RequesterService;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Requester", description = "Classe referência para Solicitantes")
@RequiredArgsConstructor
@Controller("/api/requesters")
public class RequesterController {

    private final RequesterService service;

    @Operation(summary = "Obter todos os registros da classe solicitantes")
    @DefaultResponses
    @Get
    public List<Requester> findAllRequester() {
        return service.findAll();
    }

    @Operation(summary = "Obter todos os registros da classe solicitantes filtrados por responsável=true")
    @DefaultResponses
    @Get("/responsible")
    public List<Requester> findAllRequesterByResponsibleTrue() {
        return service.findAllByResponsibleTrue();
    }

    @Operation(summary = "Obter todos os registros da classe solicitantes filtrados por bloqueado=false")
    @DefaultResponses
    @Get("/blocked-false")
    public List<Requester> findByBlockedFalse() {
        return service.findByBlockedFalse();
    }

    @Operation(summary = "Obter um solicitante pelo ID")
    @DefaultResponses
    @Get("/{id}")
    public Requester findRequesterById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @Operation(summary = "Criar novo registro na classe solicitantes")
    @DefaultResponses
    @Post("/save")
    public Requester createRequester(@Body @Valid Requester requester) {
        return service.save(requester);
    }

    @Operation(summary = "Atualizar um registro na classe solicitantes")
    @DefaultResponses
    @Put("/update")
    public Requester updateRequester(@Body @Valid Requester requester) {
        return service.update(requester);
    }

    @Operation(summary = "Excluir um registro da classe solicitantes pelo ID")
    @DefaultResponses
    @Delete("/delete/{id}")
    public void deleteRequesterById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @Operation(summary = "Excluir um registro da classe solicitantes")
    @DefaultResponses
    @Delete("/delete")
    public void deleteRequester(@Body @Valid Requester requester) {
        service.delete(requester);
    }
}