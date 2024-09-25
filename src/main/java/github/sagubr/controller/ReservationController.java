package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Reservation;
import github.sagubr.services.ReservationService;
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
@Tag(name = "Reservation", description = "Operações relacionadas a entidade reservas")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/reservations")
public class ReservationController {

    private final ReservationService service;

    @Operation(summary = "Obter todas as reservas")
    @DefaultResponses
    @Get
    public List<Reservation> getAllReservations() {
        return service.findAll();
    }
}
