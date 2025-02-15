package github.sagubr.logs;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingFilter extends Filter<ILoggingEvent> {

    //private final LoggingPublisher publisher;

//    @Override
//    public FilterReply decide(LoggingEvent event) {
//        log.info("Filtrado evento: {}", event);
//        if (event.getLevel().toInt() >= Level.INFO.toInt()) {
//            //publisher.publish(event.getLevel(), event.getFormattedMessage());
//        }
//        return FilterReply.ACCEPT;
//    }

    @Override
    public FilterReply decide(ILoggingEvent event) {
        log.info("Filtrado evento: {}", event);
        return null;
    }
}

