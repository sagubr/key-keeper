package github.sagubr.logs;

import ch.qos.logback.classic.Level;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Logging(String level, String message) {
    public Logging(Level level, String message) {
        this(level.toString(), message);
    }
}
