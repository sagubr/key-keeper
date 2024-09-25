package github.sagubr.repositories;

import github.sagubr.entities.Reservation;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

@Introspected
@Repository
public interface ReservationRepository extends PatternRepository<Reservation> {
}
