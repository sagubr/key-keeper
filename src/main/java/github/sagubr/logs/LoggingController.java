package github.sagubr.logs;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.sse.Event;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@Singleton
@Controller("/logging")
@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Logging", description = "Operações relacionadas a entidade Permissão")
@RequiredArgsConstructor
public class LoggingController {

    private final LoggingService service;

    @Get(value = "/get", produces = MediaType.TEXT_EVENT_STREAM)
    public Flux<Event<LoggingEvent>> streamLogging() {
        log.info("[{}] - Novo cliente conectado ao SSE.", LoggingType.WORKFLOW);
        return service.getLogging()
                .map(logging -> Event.of(logging))
                .doOnSubscribe(subscription -> log.info("Fluxo de logs iniciado para o cliente SSE."))
                .doOnCancel(() -> log.info("[{}] - Cliente desconectado do SSE.", LoggingType.WORKFLOW));
    }

}
