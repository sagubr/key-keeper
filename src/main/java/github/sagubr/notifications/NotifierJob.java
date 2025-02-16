package github.sagubr.notifications;

import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class NotifierJob {

    private final NotifierEventPublisher publisher;

    /**
     * Job que dispara a cada X milisegundos uma publisher.
     * As classes que estiverem ouvindo a publisher, executam alguma ação.
     */
    @Scheduled(fixedRate = "30s")
    void triggerNotifications() {
        publisher.publish("sousagustavogarcia@gmail.com", "Sua chave está pronta para retirada!");
    }

}
