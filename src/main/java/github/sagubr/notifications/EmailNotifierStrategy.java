package github.sagubr.notifications;

import github.sagubr.logs.LoggingType;
import github.sagubr.mail.EmailService;
import github.sagubr.mail.EmailTemplate;
import github.sagubr.mail.SendGridEmailService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@Singleton
@RequiredArgsConstructor
public class EmailNotifierStrategy implements NotifierStrategy {

    private final EmailService service;

    @Override
    public void send(NotifierEvent notifierEvent) {
        service.send(notifierEvent.recipient(), EmailTemplate.WELCOME.content(), Map.of("name", notifierEvent.recipient())).subscribe();
    }
}

