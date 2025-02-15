package github.sagubr.logs;

import ch.qos.logback.classic.Level;
import io.micronaut.context.event.ApplicationEventPublisher;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class LoggingPublisher {

    private final ApplicationEventPublisher<Logging> publisher;

    public void publish(Level level, String message) {
        log.info("Publicando log: {} - {}", level, message);
        publisher.publishEvent(new Logging(level, message));
    }

}
