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

    @Cacheable("reservations-status")
    public List<Reservation> findByStatus(Status status) {
        return this.repository.findByStatus(status);
    }

    @Transactional
    @CacheInvalidate("reservations")
    public void updateActive(@NotNull UUID id, @NotNull boolean active) {
        repository.updateActive(id, active);
    }

    @Transactional
    @CacheInvalidate("reservations")
    public void changeStatus(@NotNull UUID id) {
        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found for id: " + id));

        if (reservation.getStatus() == null) {
            throw new IllegalStateException("Status cannot be null for reservation id: " + id);
        }

        switch (reservation.getStatus()) {
            case SCHEDULED -> repository.changeStatus(id, Status.LOAN);
            case LOAN -> repository.changeStatus(id, Status.COMPLETED);
            case COMPLETED -> {
            }
            default -> throw new IllegalArgumentException("Invalid status: " + reservation.getStatus());
        }
    }

    @Cacheable("reservations")
    public List<Reservation> findAll() {
        return repository.findAll();
    }

    @Cacheable("reservation")
    public Optional<Reservation> findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    @CacheInvalidate(value = {"reservations", "reservation"})
    public Reservation save(Reservation entity) {
        return repository.save(entity);
    }

    @Transactional
    @CacheInvalidate(value = {"reservations", "reservation"})
    public Reservation update(Reservation entity) {
        return repository.update(entity);
    }

    @Transactional
    @CacheInvalidate(value = {"reservations", "reservation"})
    public void delete(Reservation entity) {
        repository.delete(entity);
    }

    @Transactional
    @CacheInvalidate("reservations")
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}