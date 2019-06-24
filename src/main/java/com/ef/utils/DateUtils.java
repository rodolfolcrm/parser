package com.ef.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final String FILE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    public static LocalDateTime convertFileDateTime(String text) {
        return LocalDateTime.parse(text, DateTimeFormatter.ofPattern(FILE_DATE_FORMAT));
    }
}