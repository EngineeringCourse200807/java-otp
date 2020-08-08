package com.odde.securetoken;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class BudgetService {
    private final BudgetRepo budgetRepo;

    public BudgetService(BudgetRepo budgetRepo) {
        this.budgetRepo = budgetRepo;
    }

    public int query(LocalDate startDate, LocalDate endDate) {
        if (budgetRepo.findAll().isEmpty()) {
            return 0;
        }
        return 10 * ((int) DAYS.between(startDate, endDate) + 1);
    }
}
