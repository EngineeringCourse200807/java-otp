package com.odde.securetoken;

import java.time.LocalDate;

public class BudgetService {
    private final BudgetRepo budgetRepo;

    public BudgetService(BudgetRepo budgetRepo) {
        this.budgetRepo = budgetRepo;
    }

    public int query(LocalDate startDate, LocalDate endDate) {
        return budgetRepo.findAll().stream().
                mapToInt(budget -> budget.getOverlappingAmount(new Period(startDate, endDate))).
                sum();
    }

}
