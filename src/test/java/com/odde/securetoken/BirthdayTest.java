package com.odde.securetoken;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BirthdayTest {

    @Test
    public void is_birthday() {
        Birthday birthday = new Birthday(new TimeProvider() {
            @Override
            public LocalDate getToday() {
                return LocalDate.parse("2020-04-08");
            }
        });

        boolean actual = birthday.isBirthday();

        assertTrue(actual);
    }

}