package github.sagubr.notifications;

import github.sagubr.entities.Notification;
import github.sagubr.entities.Reservation;
import github.sagubr.mail.EmailService;
import github.sagubr.mail.EmailTemplate;
import github.sagubr.services.NotificationService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class EmailNotifierStrategy implements NotifierStrategy {

    private final EmailService service;
    private final NotificationService notificationService;

    @Override
    public void send(NotifierEvent event) {

        Notification notification = event.notification();
        Reservation reservation = notification.getReservation();

        reservation
                .getRequester()
                .getEmails()
                .forEach(email ->
                        service.send(
                                email,
                                EmailTemplate.COBRANCA_EMAIL,
                                Map.of(
                                        "name", reservation.getRequester().getName(),
                                        "room", reservation.getLocation().getName(),
                                        "period", reservation.getFormattedPeriod()
                                )
                        ).subscribe(
                                result -> {
                                    notification.setSend(true);
                                    notificationService.save(notification);
                                }
                        )
                );
    }
}

