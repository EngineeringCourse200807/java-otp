package com.odde.securetoken;

import java.time.LocalDate;

public class Budget {

    private LocalDate month;
    private int amount;

    public void setMonth(LocalDate month) {
        this.month = month;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Period getPeriod() {
        return new Period(month, month.withDayOfMonth(month.lengthOfMonth()));
    }

    public int getDailyAmount() {
        return amount / month.lengthOfMonth();
    }

    public int getOverlappingAmount(Period period) {
        return getDailyAmount() * period.getOverlappingDayCount(getPeriod());
    }
}
