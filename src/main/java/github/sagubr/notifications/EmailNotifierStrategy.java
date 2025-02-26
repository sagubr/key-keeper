package github.sagubr.notifications;

import github.sagubr.entities.Requester;
import github.sagubr.entities.Reservation;
import github.sagubr.mail.EmailService;
import github.sagubr.mail.EmailTemplate;
import github.sagubr.services.ReservationService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class EmailNotifierStrategy implements NotifierStrategy {

    private final EmailService service;
    private final ReservationService reservationService;

    @Override
    public void send(NotifierEvent notifierEvent) {

        Reservation reservation = notifierEvent.reservation();

        reservation.getRequester()
                .getEmails().forEach(email ->
                        service.send(
                                email,
                                EmailTemplate.COBRANCA_EMAIL,
                                Map.of(
                                        "name", reservation.getRequester().getName(),
                                        "room", reservation.getLocation().getName(),
                                        "startDate", reservation.getStartDateTimeFormatted(),
                                        "endDate", reservation.getEndDateTimeFormatted()
                                )
                        ).subscribe(
                                result -> {
                                    reservation.setNotificationSent(true);
                                    reservationService.update(reservation);
                                }
                        )
                );
    }
}

