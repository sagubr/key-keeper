package github.sagubr.notifications;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class EmailNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(Notification notification) {
        log.info("Enviando e-mail para {}: {}", notification);
    }
}

