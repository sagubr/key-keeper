package github.sagubr.logs;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Appender personalizado para capturar logs e publicá-los via {@link LoggingEventPublisher}.
 */
@Slf4j
public class LoggingAppender extends AppenderBase<ILoggingEvent> {

    private static LoggingEventPublisher publisher;

    /** Fila temporária para armazenar logs caso o publisher ainda não esteja disponível */
    private static final ConcurrentLinkedQueue<ILoggingEvent> backlog = new ConcurrentLinkedQueue<>();

    /**
     * Define o publisher para o appender e envia logs pendentes armazenados na fila.
     *
     * @param loggingEventPublisher Instância do {@link LoggingEventPublisher} injetada pelo Micronaut.
     */
    public static void setPublisher(LoggingEventPublisher loggingEventPublisher) {
        publisher = loggingEventPublisher;

        while (!backlog.isEmpty()) {
            ILoggingEvent event = backlog.poll();
            if (event != null) {
                publisher.publish(Level.valueOf(event.getLevel().toString()), event.getFormattedMessage());
            }
        }
    }

    /**
     * Método chamado automaticamente pelo Logback para processar eventos de log.
     * Se o publisher não estiver disponível, o log é armazenado na fila temporária.
     *
     * @param event Evento de log recebido pelo appender.
     */
    @Override
    protected void append(ILoggingEvent event) {
        if (publisher == null) {
            log.warn("Publisher ainda não foi configurado. Armazenando log temporariamente.");
            backlog.add(event);
            return;
        }
        publisher.publish(Level.valueOf(event.getLevel().toString()), event.getFormattedMessage());
    }
}
