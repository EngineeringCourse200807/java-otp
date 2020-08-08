package com.odde.securetoken;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class BudgetService {
    private final BudgetRepo budgetRepo;

    public BudgetService(BudgetRepo budgetRepo) {
        this.budgetRepo = budgetRepo;
    }

    public int query(LocalDate startDate, LocalDate endDate) {
        List<Budget> all = budgetRepo.findAll();
        if (all.isEmpty()) {
            return 0;
        }
        Budget budget = all.get(0);
        return 10 * getOverlappingDayCount(startDate, endDate, budget);
    }

    private int getOverlappingDayCount(LocalDate startDate, LocalDate endDate, Budget budget) {
        LocalDate overlappingEnd = endDate.isBefore(budget.getEndOfBudget()) ? endDate : budget.getEndOfBudget();
        LocalDate overlappingStart = startDate.isAfter(budget.getMonth()) ? startDate : budget.getMonth();
        return (int) DAYS.between(overlappingStart, overlappingEnd) + 1;
    }

}
