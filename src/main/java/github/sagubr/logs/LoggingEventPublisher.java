package github.sagubr.logs;

import ch.qos.logback.classic.Level;
import io.micronaut.context.event.ApplicationEventPublisher;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class LoggingEventPublisher {

    private final ApplicationEventPublisher<LoggingEvent> publisher;

    public void publish(Level level, String message) {
        publisher.publishEvent(new LoggingEvent(level, message));
    }

}
