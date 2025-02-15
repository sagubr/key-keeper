package github.sagubr.notifications;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class SmsNotifierStrategy implements NotifierStrategy {

    @Override
    public void send(NotifierEvent notifierEvent) {
        log.info("Enviando SMS para {}: {}", notifierEvent.recipient(), notifierEvent.message());
    }

}
