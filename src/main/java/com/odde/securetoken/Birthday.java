package com.odde.securetoken;

import java.time.LocalDate;

import static java.time.Month.APRIL;

public class Birthday {

    private final TimeProvider clock;

    public Birthday(TimeProvider clock) {
        this.clock = clock;
    }

    public boolean isBirthday() {
        LocalDate today = clock.getToday();
        return today.getDayOfMonth() == 9 && today.getMonth().equals(APRIL);
    }
}