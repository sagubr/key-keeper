package github.sagubr.controller;

import github.sagubr.notifications.NotifierEvent;
import github.sagubr.services.NotificationService;
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
@Controller("/notifications")
@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Notifications", description = "Operações relacionadas a entidade Permissão")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    /**
     * Endpoint para os clientes se inscreverem e receberem notificações.
     */
    @Get(value = "/pop-up", produces = MediaType.TEXT_EVENT_STREAM)
    public Flux<Event<NotifierEvent>> streamNotifications() {
        log.info("Novo cliente conectado ao SSE.");
        return notificationService.getNotificationFlux()
                .map(notification -> Event.of(notification))
                .doOnCancel(() -> log.info("Cliente desconectado do SSE."));
    }
}

