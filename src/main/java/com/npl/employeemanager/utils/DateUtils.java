package com.npl.employeemanager.utils;

import java.time.Duration;
import java.time.LocalDateTime;

public class DateUtils {

    public static long getDaysBetweenLocalDateTimes(LocalDateTime start, LocalDateTime end) {
       long days= Duration.between(start.withHour(0),end.withHour(0)).toDays();
        System.out.println("days = " + days);
       return  days;
    }
}
