package github.sagubr.notifications;

import github.sagubr.entities.Reservation;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record NotifierEvent(Reservation reservation, String message) {}
