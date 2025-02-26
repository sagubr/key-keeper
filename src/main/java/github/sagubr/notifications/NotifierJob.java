package github.sagubr.notifications;

import github.sagubr.entities.Reservation;
import github.sagubr.services.ReservationService;
import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
@RequiredArgsConstructor
public class NotifierJob {

    private final ReservationService service;
    private final NotifierEventPublisher publisher;

    /**
     * Job que dispara a cada X milisegundos uma publisher.
     * As classes que estiverem ouvindo a publisher, executam alguma ação.
     */
    @Scheduled(fixedRate = "30s")
    void triggerNotifications() {

        List<Reservation> reservations = service.findAll().stream().filter(
                        reservation ->
                                reservation.isOverdue() && !reservation.isNotificationSent())
                .collect(Collectors.toList());

        if (reservations.isEmpty()) {
            return;
        }
        //TODO: Converter entidade Reservation para um ReservationPublisherDto com o keyCode.
        //TODO: só enviar e-mail para os status == EMPRESTIMO
        reservations.forEach(reservation -> publisher.publish(reservation, ""));
    }

}
