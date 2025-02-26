package github.sagubr.controller;

import github.sagubr.mail.EmailService;
import github.sagubr.mail.EmailTemplate;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import java.util.Map;

@Slf4j
@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Email", description = "Operações relacionadas a envio de e-mail")
@Controller("/mail")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService service;

    @Post("/send")
    public Publisher<HttpResponse<?>> send(@Body("to") String to) {
        log.info("Recebida solicitação para enviar e-mail para {}", to);

        return Mono.from(service.send(to, EmailTemplate.BEM_VINDO, Map.of("name", to)))
                .map(success -> success ? HttpResponse.accepted() : HttpResponse.unprocessableEntity());
    }
}

