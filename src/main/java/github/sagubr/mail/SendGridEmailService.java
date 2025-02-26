package github.sagubr.mail;

import com.sendgrid.Request;
import com.sendgrid.Response;
import github.sagubr.logs.LoggingType;
import io.micronaut.context.annotation.Value;
import io.micronaut.email.AsyncEmailSender;
import io.micronaut.email.BodyType;
import io.micronaut.email.Email;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.Map;

@Slf4j
@Singleton
public class SendGridEmailService implements EmailService {

    private AsyncEmailSender<Request, Response> email;
    private final TemplateService templateService;

    @Inject
    public SendGridEmailService(AsyncEmailSender<Request, Response> emailSender, TemplateService templateService) {
        this.templateService = templateService;
        this.email = emailSender;
    }

    @Value("${micronaut.email.from.email}")
    private String from;

    @Value("${micronaut.email.from.name}")
    private String name;

    @Override
    public Mono<Boolean> send(String to, EmailTemplate templateName, Map<String, Object> params) {

        String content = templateService.renderTemplate(templateName.content(), params);
        return Mono.from(email.sendAsync(
                        Email.builder()
                                .from(from)
                                .to(to)
                                .subject(templateName.subject())
                                .body(content, BodyType.HTML)
                ))
                .doOnNext(response -> log.info("[{}]Enviando e-mail para {}", LoggingType.EVENT, to))
                .doOnError(error -> log.error("[{}] Falha ao enviar e-mail: {}", LoggingType.EVENT, error.getMessage(), error))
                .map(response -> response != null && response.getStatusCode() < 400);
    }

}