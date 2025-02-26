package github.sagubr.mail;

import reactor.core.publisher.Mono;

import java.util.Map;

public interface EmailService {

    Mono<Boolean> send(String to, EmailTemplate templateName, Map<String, Object> params);

}
