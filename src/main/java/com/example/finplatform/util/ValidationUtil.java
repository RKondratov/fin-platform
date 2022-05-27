package com.example.finplatform.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidationUtil {
    public static boolean checkId(String id) {
        return id.matches("[-+]?\\d+");
    }

    public static boolean isValidDate(String dateStr) {
        try {
            LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
            return LocalDate.now().isAfter(date);
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}