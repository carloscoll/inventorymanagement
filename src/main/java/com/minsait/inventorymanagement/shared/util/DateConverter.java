package com.minsait.inventorymanagement.shared.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    public static LocalDateTime convertStringToLocalDateTime(String dateString) {
        return LocalDateTime.parse(dateString, FORMATTER);
    }

    public static String convertLocalDateTimeToString(LocalDateTime date) {
        return date.format(FORMATTER);
    }
}