package com.odde.securetoken;

import java.time.LocalDate;

public class Budget {

    private LocalDate month;
    private int amount;

    public LocalDate getMonth() {
        return month;
    }

    public void setMonth(LocalDate month) {
        this.month = month;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
