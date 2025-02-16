package github.sagubr.logs;

import ch.qos.logback.classic.Level;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record LoggingEvent(String level, String message) {
    public LoggingEvent(Level level, String message) {
        this(level.toString(), message);
    }
}
