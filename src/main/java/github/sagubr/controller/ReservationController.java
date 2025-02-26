
package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Reservation;
import github.sagubr.entities.Status;
import github.sagubr.entities.User;
import github.sagubr.services.ReservationService;
import github.sagubr.services.UserService;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Operation(summary = "Obter reserva por ID")
    @DefaultResponses
    @Get("/{id}")
    public Optional<Reservation> findByIdReservation(UUID id) {
        return service.findById(id);
    }

    @Operation(summary = "Obter todas as reservas filtradas por status")
    @DefaultResponses
    @Get("/status")
    public List<Reservation> findAllByStatusReservation(@QueryValue List<Status> status) {
        return service.findByStatus(status);
    }

    @Operation(summary = "Criar nova reserva")
    @DefaultResponses
    @Post("/save")
    public Reservation createReservation(@Body @Valid Reservation reservation, Principal principal) {
        User user = userService.findByUsername(principal).orElseThrow();
        reservation.setUser(user);
        return service.save(reservation);
    }

    @Operation(summary = "Atualizar uma reserva")
    @DefaultResponses
    @Put("/update/")
    public Reservation updateReservation(@Body @Valid Reservation reservation) {
        return service.update(reservation);
    }

    @Operation(summary = "Excluir uma reserva por ID")
    @DefaultResponses
    @Delete("/delete/{id}")
    public void deleteByIdReservation(UUID id) {
        service.deleteById(id);
    }

    @Operation(summary = "Atualizar status de uma reserva")
    @DefaultResponses
    @Put("/change-status")
    public void changeStatusReservation(@Body @Valid Reservation reservation) {
        service.changeStatus(reservation);
    }

    @Operation(summary = "Atualizar campo ativo de uma reserva")
    @DefaultResponses
    @Post("/active")
    public void updateActiveReservation(@Body @Valid Reservation reservation) {
        service.updateActive(reservation.getId(), reservation.isActive());
    }
}
