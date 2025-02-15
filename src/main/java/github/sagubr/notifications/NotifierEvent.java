package github.sagubr.notifications;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record NotifierEvent(String recipient, String message) {}
