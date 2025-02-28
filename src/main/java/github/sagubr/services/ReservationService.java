package github.sagubr.services;

import github.sagubr.commands.ReservationChangeStatusCommand;
import github.sagubr.commands.ReservationCommand;
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
    public List<Reservation> findAll() {
        return repository.findAll();
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

        if(!command.getPermission().location().isPublicAccess()){
            permission = permissionService.findById(command.getPermission().permissionId());
        }

        Reservation reservation = Reservation.builder()
                .user(user)
                .location(command.getPermission().location())
                .requester(command.getRequester())
                .permission(permission)
                .status(command.getStatus())
                .startDateTime(command.getStartDateTime())
                .endDateTime(command.getEndDateTime())
                .build();

        return repository.save(reservation);
    }

    @Transactional
    @CacheInvalidate(value = "reservations", all = true)
    public Reservation update(Reservation entity) {
        return repository.update(entity);
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


}