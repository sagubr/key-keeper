package github.sagubr.repositories;

import github.sagubr.entities.Location;
import github.sagubr.entities.Reservation;
import github.sagubr.entities.Status;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Introspected
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

    @Query("""
        SELECT COUNT(r) > 0 FROM Reservation r
        WHERE r.location = :location
        AND (:startDateTime BETWEEN r.startDateTime AND r.endDateTime
             OR :endDateTime BETWEEN r.startDateTime AND r.endDateTime
             OR (r.startDateTime BETWEEN :startDateTime AND :endDateTime))
        AND r.status IN (:status)
    """)
    boolean existsByLocationAndPeriodOverlap(Location location, ZonedDateTime startDateTime, ZonedDateTime endDateTime, List<Status> status);

    List<Reservation> findByActiveTrue();

    List<Reservation> findByNotificationFalse();

    List<Reservation> findByNotificationFalseAndStatusAndEndDateTimeBefore(Status status, ZonedDateTime now);

    List<Reservation> findByActiveTrueAndStatusIn(List<Status> status);

    @Query(value = "UPDATE reservations r SET r.active = :active WHERE r.id = :id"
            , nativeQuery = true)
    void updateActive(@Id UUID id, boolean active);

}
