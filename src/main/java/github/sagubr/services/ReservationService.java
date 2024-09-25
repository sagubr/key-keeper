package github.sagubr.services;

import github.sagubr.entities.Reservation;
import github.sagubr.repositories.ReservationRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Inject))
@Singleton
public class ReservationService {

    private final ReservationRepository repository;

    @Transactional
    public List<Reservation> findAll() {
        return repository.findAll();
    }
}
