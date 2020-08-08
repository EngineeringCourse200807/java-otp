package com.odde.securetoken;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Period {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Period(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getOverlappingDayCount(Period another) {
        if (endDate.isBefore(another.startDate) || startDate.isAfter(another.endDate)) {
            return 0;
        }
        LocalDate overlappingEnd = endDate.isBefore(another.endDate) ? endDate : another.endDate;
        LocalDate overlappingStart = startDate.isAfter(another.startDate) ? startDate : another.startDate;
        return (int) DAYS.between(overlappingStart, overlappingEnd) + 1;
    }
}
