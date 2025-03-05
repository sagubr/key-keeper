package github.sagubr.controller;

import github.sagubr.annotations.DefaultResponses;
import github.sagubr.entities.Notification;
import github.sagubr.services.NotificationService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@Slf4j
@Singleton
@Controller("/notifications")
@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Notifications", description = "Operações relacionadas a entidade Notificação")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    //TODO: Tem que filtrar os CANCELADOS, não pode exibir
    @Operation(summary = "Obter todos os registros da classe notificação que não tenham sido lidos")
    @DefaultResponses
    @Get("/pop-up")
    public List<Notification> findByReadFalse() {
        return notificationService.findByReadFalse();
    }

    @Operation(summary = "Marcar o registro de notificação como lida")
    @DefaultResponses
    @Post("/read/{notificationId}")
    public Notification markAsRead(@PathVariable UUID notificationId) {
        return notificationService.markRead(notificationId);
    }

}

