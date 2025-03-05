package github.sagubr.repositories;

import github.sagubr.entities.Notification;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Introspected
@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {

    List<Notification> findByReadTrue();

    List<Notification> findByReadFalse();

    Optional<Notification> findByReservationId(UUID id);

}
