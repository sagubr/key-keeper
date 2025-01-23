package github.sagubr.services;

import github.sagubr.entities.Reservation;
import github.sagubr.entities.Status;
import github.sagubr.repositories.ReservationRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.experimental.SuperBuilder;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.List;
import java.util.UUID;

@Singleton
@SuperBuilder
public class ReservationService extends GenericService<Reservation, UUID> {

    private final ReservationRepository repository;

    @Inject
    public ReservationService(
            ReservationRepository repository
    ) {
        super(repository);
        this.repository = repository;
    }

    public List<Reservation> findByStatus(Status status) {
        return this.repository.findByStatus(status);
    }

    @Transactional
    public void updateActive(@NotNull UUID id, @NotNull boolean active) {
        try {
            repository.updateActive(id, active);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while updating the entity.", e);
        }
    }

    @Transactional
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

}
