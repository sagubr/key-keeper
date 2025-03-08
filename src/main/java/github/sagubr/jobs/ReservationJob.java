package github.sagubr.jobs;

import github.sagubr.commands.ReservationChangeStatusCommand;
import github.sagubr.commands.ReservationCommand;
import github.sagubr.entities.Notification;
import github.sagubr.entities.Reservation;
import github.sagubr.entities.Status;
import github.sagubr.notifications.NotifierEventPublisher;
import github.sagubr.services.NotificationService;
import github.sagubr.services.ReservationService;
import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class ReservationJob {

    private final ReservationService reservationService;
    private final NotificationService notificationService;
    private final NotifierEventPublisher publisher;

    @Scheduled(fixedRate = "10s")
    void processOverdueReservationsNotifications() {
        log.info("Buscando reservas sem notificação com devolução atrasada");
        List<Reservation> overdueReservations = reservationService.findByNotificationFalseAndStatusAndEndDateTimeBefore();
        if (overdueReservations.isEmpty()) return;

        log.info("Encontrado {} reserva(s) com a devolução atrasada sem notificação", overdueReservations.size());
        overdueReservations.forEach(this::handleOverdueNotification);
    }

    private void handleOverdueNotification(Reservation reservation) {
        ReservationChangeStatusCommand command = new ReservationChangeStatusCommand(reservation.getId(), Status.ATRASADO);
        reservationService.changeStatus(command);

        if (!notificationService.findByReservationId(reservation.getId()).isEmpty()) return;

        Notification notification = createOverdueNotification(reservation);

        notificationService.save(notification);
        reservationService.setNotificationTrue(reservation.getId());
        log.info("Publicando notificação de reserva atrasada.");
        publisher.publish(notification);
    }

    private Notification createOverdueNotification(Reservation reservation) {
        Map<String, String> metadata = Map.of(
                "title", "Devolução Atrasada",
                "message", "O solicitante foi notificado."
        );

        return Notification.builder()
                .name("DEVOLUÇÃO ATRASADA")
                .reservation(reservation)
                .metadata(metadata)
                .build();
    }


}