package github.sagubr.services;

import github.sagubr.entities.Reservation;
import github.sagubr.entities.Status;
import github.sagubr.repositories.ReservationRepository;
import io.micronaut.cache.annotation.CacheInvalidate;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Singleton
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository repository;

    @Cacheable(value = "reservations-status", parameters = "status")
    public List<Reservation> findByStatus(List<Status> status) {
        return this.repository.findByStatusIn(status);
    }

    @Transactional
    @CacheInvalidate(value = "reservations", all = true)
    public void updateActive(@NotNull UUID id, @NotNull boolean active) {
        repository.updateActive(id, active);
    }

    @Transactional
    @CacheInvalidate(value = "reservations", all = true)
    public void changeStatus(@NotNull Reservation reservation) {

        if(reservation.getStatus() == Status.CANCELADO){
            throw new Error("Empréstimo já está cancelado");
        }

        repository.update(reservation);
    }

    @Cacheable("reservations")
    public List<Reservation> findAll() {
        return repository.findAll();
    }

    @Cacheable(value = "reservation", parameters = "id")
    public Optional<Reservation> findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    @CacheInvalidate(value = "reservations", all = true)
    public Reservation save(Reservation entity) {
        return repository.save(entity);
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