package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Assignment;
import github.sagubr.services.AssignmentService;
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
@Tag(name = "Assignment", description = "Classe referência para Atribuição")
@RequiredArgsConstructor
@Controller("/api/assignment")
public class AssignmentController {

    private final AssignmentService service;

    @Operation(summary = "Obter todos os registros da classe atribuição")
    @DefaultResponses
    @Get
    public List<Assignment> findAllAssignment() {
        return service.findAll();
    }

    @Operation(summary = "Criar novo registro na classe atribuição")
    @DefaultResponses
    @Post(value = "/save")
    public Assignment createAssignment(@Body @Valid Assignment assignment) {
        return service.save(assignment);
    }

}
