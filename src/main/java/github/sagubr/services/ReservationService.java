package github.sagubr.services;

import github.sagubr.commands.ReservationChangeStatusCommand;
import github.sagubr.commands.ReservationCommand;
import github.sagubr.commands.ReservationProlongationCommand;
import github.sagubr.entities.Permission;
import github.sagubr.entities.Reservation;
import github.sagubr.entities.Status;
import github.sagubr.entities.User;
import github.sagubr.repositories.ReservationRepository;
import io.micronaut.cache.annotation.CacheInvalidate;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import java.security.Principal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Singleton
@RequiredArgsConstructor
public class ReservationService {


    private final ReservationRepository repository;
    private final PermissionService permissionService;
    private final UserService userService;

    @Cacheable(value = "reservations", parameters = "status")
    public List<Reservation> findByActiveTrueAndStatusIn(List<Status> status) {
        return this.repository.findByActiveTrueAndStatusIn(status);
    }

    @Transactional
    @CacheInvalidate(value = "reservations", all = true)
    public void updateActive(@NotNull UUID id, @NotNull boolean active) {
        repository.updateActive(id, active);
    }

    @Transactional
    @CacheInvalidate(value = "reservations", all = true)
    public void changeStatus(@NotNull ReservationChangeStatusCommand command) {
        Reservation reservation =
                repository.findById(command.getReservationId()).orElseThrow(EntityNotFoundException::new);
        reservation.setStatus(command.getStatus());
        repository.save(reservation);
    }

    @Cacheable("reservations")
    public List<Reservation> findByActiveTrue() {
        return repository.findByActiveTrue();
    }

    @Cacheable(value = "reservations", parameters = "id")
    public Optional<Reservation> findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    @CacheInvalidate(value = "reservations", all = true)
    public Reservation save(ReservationCommand command, Principal principal) {

        User user = userService.findByUsername(principal).orElseThrow();
        Permission permission = null;

        if (!command.getPermission().location().isPublicAccess()) {
            permission = permissionService.findById(command.getPermission().permissionId());
        }

        boolean existsConflict = repository.existsByLocationAndPeriodOverlap(
                command.getPermission().location(),
                command.getStartDateTime(),
                command.getEndDateTime(),
                List.of(Status.AGENDADO, Status.EMPRESTIMO)
        );

        if (existsConflict) {
            throw new IllegalStateException("Já existe uma reserva para este período e local.");
        }

        Reservation reservation = Reservation.builder()
                .user(user)
                .location(command.getPermission().location())
                .requester(command.getRequester())
                .key(command.getKey())
                .permission(permission)
                .status(command.getStatus())
                .startDateTime(command.getStartDateTime())
                .endDateTime(command.getEndDateTime())
                .build();

        return repository.save(reservation);
    }

    @Transactional
    @CacheInvalidate(value = "reservations", all = true)
    public Reservation update(ReservationProlongationCommand command) {
        return repository.findById(command.getReservationId())
                .map(existing -> {
                    existing.setStartDateTime(command.getStartDateTime());
                    existing.setEndDateTime(command.getEndDateTime());
                    if (!existing.isOverdue()) existing.setStatus(Status.EMPRESTIMO);

                    return repository.update(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("Solicitante não encontrado na base de dados."));
    }

    @Transactional
    @CacheInvalidate(value = "reservations", all = true)
    public Reservation setNotificationTrue(UUID reservationId) {
        Reservation reservation = repository.findById(reservationId).orElseThrow();
        reservation.setNotification(true);
        return repository.save(reservation);
    }

    @Transactional
    @CacheInvalidate(value = "reservations", all = true)
    public void delete(Reservation entity) {
        repository.delete(entity);
    }

    @Transactional
    @CacheInvalidate(value = "reservations", all = true)
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public List<Reservation> findByNotificationFalse() {
        return repository.findByNotificationFalse();
    }

    public List<Reservation> findByNotificationFalseAndStatusAndEndDateTimeBefore() {
        return repository.findByNotificationFalseAndStatusAndEndDateTimeBefore(Status.EMPRESTIMO, ZonedDateTime.now());
    }

}