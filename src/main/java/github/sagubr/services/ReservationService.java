package github.sagubr.services;

import github.sagubr.entities.Reservation;
import github.sagubr.repositories.ReservationRepository;
import jakarta.inject.Singleton;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Singleton
@SuperBuilder
public class ReservationService extends GenericService<Reservation, UUID> {

    private final ReservationRepository repository;

}
