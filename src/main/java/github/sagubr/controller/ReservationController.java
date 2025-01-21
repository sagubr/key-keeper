package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Reservation;
import github.sagubr.entities.Status;
import github.sagubr.entities.User;
import github.sagubr.services.ReservationService;
import github.sagubr.services.UserService;
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

import java.security.Principal;
import java.util.List;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Reservation", description = "Operações relacionadas a entidade reservas")
@AllArgsConstructor(onConstructor = @__(@Inject))
@Controller("/api/reservations")
public class ReservationController {

    private final ReservationService service;
    private final UserService userService;

    @Operation(summary = "Obter todas as reservas")
    @DefaultResponses
    @Get
    public List<Reservation> findAllReservation() {
        return service.findAll();
    }

    @Operation(summary = "Obter todas as reservas")
    @DefaultResponses
    @Get(value = "/status")
    public List<Reservation> findAllByStatusReservation(@Valid Status status) {
        return service.findByStatus(status);
    }

    @Operation(summary = "Obter todas as reservas")
    @DefaultResponses
    @Post(value = "/save")
    public Reservation addReservation(@Body @Valid Reservation reservation, Principal principal) {
        User user = userService.findByUsername(principal).get();
        reservation.setUser(user);
        return service.save(reservation);
    }

    @Operation(summary = "Obter todas as reservas")
    @DefaultResponses
    @Post(value = "/active")
    public void updateActiveReservation(@Body @Valid Reservation reservation) {
        service.updateActive(reservation.getId(), reservation.isActive());
    }

}
