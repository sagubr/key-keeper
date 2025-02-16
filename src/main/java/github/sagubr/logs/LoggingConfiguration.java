package github.sagubr.logs;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.Appender;
import io.micronaut.context.annotation.Context;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;

@Singleton
@Context
@RequiredArgsConstructor
public class LoggingConfiguration {

    private final LoggingEventPublisher publisher;

    @EventListener
    public void onStartup(ServerStartupEvent event) {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = context.getLogger(Logger.ROOT_LOGGER_NAME);
        Appender<?> appender = rootLogger.getAppender("CUSTOM");

        if (appender instanceof LoggingAppender) {
            LoggingAppender.setPublisher(publisher);
        }
    }
}
