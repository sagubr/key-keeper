package github.sagubr.notifications;

import io.micronaut.scheduling.annotation.Scheduled;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

@Singleton
@RequiredArgsConstructor
public class NotificationJob {

    private final NotificationPublisher publisher;

    @Scheduled(fixedRate = "10s") // Executa a cada 1 minuto
    void triggerNotifications() {
        publisher.publish("email@teste.com", "Sua chave está pronta para retirada!");
    }
}
