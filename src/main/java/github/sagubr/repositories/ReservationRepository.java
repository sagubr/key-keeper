package github.sagubr.repositories;

import github.sagubr.entities.Reservation;
import github.sagubr.entities.Status;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@Introspected
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    List<Reservation> findByActiveTrueAndStatusIn(List<Status> status);

    @Query(value = "UPDATE reservations r SET r.active = :active WHERE r.id = :id"
            , nativeQuery = true)
    void updateActive(@Id UUID id, boolean active);

}
