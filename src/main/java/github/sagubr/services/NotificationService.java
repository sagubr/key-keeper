package github.sagubr.services;

import github.sagubr.entities.Notification;
import github.sagubr.repositories.NotificationRepository;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Singleton
public class NotificationService {

    private final NotificationRepository repository;

    public Notification save(Notification notification) {
        return repository.save(notification);
    }

    public List<Notification> findByReadFalse() {
        return repository.findByReadFalse();
    }

    public List<Notification> findByReadTrue() {
        return repository.findByReadTrue();
    }

    public Optional<Notification> findByReservationId(UUID reservationId) {
        return repository.findByReservationId(reservationId);
    }

    public Notification markRead(UUID notificationId) {
        Notification notification = repository.findById(notificationId)
                .orElseThrow(() -> new EntityNotFoundException("Notificação não foi encontrada com o ID: " + notificationId));
        notification.setRead(true);
        return repository.update(notification);
    }


}
