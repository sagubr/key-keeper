package github.sagubr.logs;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class LoggingFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
        String message = event.getFormattedMessage();
        if (Arrays.stream(LoggingType.values())
                .anyMatch(type -> message.contains(type.name()))) {
            return FilterReply.ACCEPT;
        }
        return FilterReply.DENY;
    }
}
