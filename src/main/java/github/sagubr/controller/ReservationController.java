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
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.security.Principal;
import java.util.List;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Reservation", description = "Classe referência para Reservas")
@RequiredArgsConstructor
@Controller("/api/reservations")
public class ReservationController {

    private final ReservationService service;
    private final UserService userService;

    @Operation(summary = "Obter todos os registros da classe reservas")
    @DefaultResponses
    @Get
    public List<Reservation> findAllReservation() {
        return service.findAll();
    }

    @Operation(summary = "Obter todos os registros da classe reservas filtrados por status")
    @DefaultResponses
    @Get(value = "/status")
    public List<Reservation> findAllByStatusReservation(@Valid Status status) {
        return service.findByStatus(status);
    }

    @Operation(summary = "Criar novo registro na classe reservas")
    @DefaultResponses
    @Post(value = "/save")
    public Reservation addReservation(@Body @Valid Reservation reservation, Principal principal) {
        User user = userService.findByUsername(principal).get();
        reservation.setUser(user);
        return service.save(reservation);
    }

    @Operation(summary = "Atualizar registro ativo na classe reservas")
    @DefaultResponses
    @Post(value = "/active")
    public void updateActiveReservation(@Body @Valid Reservation reservation) {
        service.updateActive(reservation.getId(), reservation.isActive());
    }

    @Operation(summary = "Atualizar registro status na classe reservas")
    @DefaultResponses
    @Post(value = "/change-status")
    public void changeStatusReservation(@Body @Valid Reservation reservation) {
        service.changeStatus(reservation.getId());
    }

}
