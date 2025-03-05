package github.sagubr.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeUtils {

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));
    private static final DateTimeFormatter TIME_FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm");

    public static String formatPeriod(ZonedDateTime startDateTime, ZonedDateTime endDateTime) {
        if (startDateTime == null || endDateTime == null) {
            return null;
        }

        ZoneId systemZone = ZoneId.systemDefault();

        startDateTime = startDateTime.withZoneSameInstant(systemZone);
        endDateTime = endDateTime.withZoneSameInstant(systemZone);

        String startDate = startDateTime.format(DATE_FORMATTER);
        String endDate = endDateTime.format(DATE_FORMATTER);
        String startTime = startDateTime.format(TIME_FORMATTER);
        String endTime = endDateTime.format(TIME_FORMATTER);

        if (startDate.equals(endDate)) {
            return String.format("%s, das %s às %s", startDate, startTime, endTime);
        }

        return String.format("%s, às %s até %s, às %s", startDate, startTime, endDate, endTime);
    }
}

