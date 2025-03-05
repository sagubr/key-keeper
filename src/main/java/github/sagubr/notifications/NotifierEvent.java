package github.sagubr.notifications;

import github.sagubr.entities.Notification;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record NotifierEvent(Notification notification) {
}
