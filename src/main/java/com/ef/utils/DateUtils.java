package com.ef.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final String FILE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    public static LocalDateTime convertFileDateTime(String text) {
        return LocalDateTime.parse(text, DateTimeFormatter.ofPattern(FILE_DATE_FORMAT));
    }

    public static LocalDateTime todayAtZeroHour() {
        return LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
    }

    public static LocalDateTime localDateTimeAtZeroHour(LocalDateTime localDateTime) {
        return localDateTime.withHour(0).withMinute(0).withSecond(0);
    }
}