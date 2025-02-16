package github.sagubr.notifications;

import github.sagubr.services.NotifierService;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Singleton
@RequiredArgsConstructor
public class NotifierEventListener {

    private final List<NotifierStrategy> strategies;

    private final NotifierService service;

    /**
     * Localiza e dispara os eventos para todas as classes que implementam o NotificationStrategy
     * @param event
     */
    @EventListener
    public void onNotificationEvent(NotifierEvent event) {
        strategies.forEach(strategy -> strategy.send(event));
        service.sendNewNotification(event);
    }

}

