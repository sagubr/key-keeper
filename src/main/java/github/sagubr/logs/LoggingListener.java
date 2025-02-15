package github.sagubr.logs;

import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class LoggingListener {

    private final LoggingService service;

    @EventListener
    public void onLoggingEvent(Logging logging) {
        log.info("Acionando serviço log: {}", logging);
        service.sendLogging(logging);
    }

}
