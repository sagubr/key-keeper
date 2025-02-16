package github.sagubr.services;

import github.sagubr.notifications.NotifierEvent;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Singleton
@RequiredArgsConstructor
public class NotifierService {

    private final Sinks.Many<NotifierEvent> sink = Sinks.many().multicast().onBackpressureBuffer();

    /**
     * Método para obter o fluxo de notificações que serão enviadas para os assinantes.
     */
    public Flux<NotifierEvent> getNotificationFlux() {
        return sink.asFlux();
    }

    /**
     * Método para enviar uma nova notificação.
     *
     * @param notifierEvent A mensagem da notificação.
     */
    public void sendNewNotification(NotifierEvent notifierEvent) {
        sink.tryEmitNext(notifierEvent);
    }
}


