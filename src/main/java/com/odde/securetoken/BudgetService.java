package com.odde.securetoken;

import java.time.LocalDate;

public class BudgetService {
    private final BudgetRepo budgetRepo;

    public BudgetService(BudgetRepo budgetRepo) {
        this.budgetRepo = budgetRepo;
    }

    public int query(LocalDate startDate, LocalDate endDate) {
        int total = 0;
        for (Budget budget : budgetRepo.findAll()) {
            total += 10 * new Period(startDate, endDate).getOverlappingDayCount(budget.getPeriod());
        }
        return total;
    }

}
