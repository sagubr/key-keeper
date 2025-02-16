package github.sagubr.logs;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class LoggingService {

    private final Sinks.Many<LoggingEvent> sink = Sinks.many().multicast().onBackpressureBuffer();

    public Flux<LoggingEvent> getLogging() {
        return sink.asFlux();
    }

    public void sendLogging(LoggingEvent logging) {
        sink.tryEmitNext(logging);
    }
}
