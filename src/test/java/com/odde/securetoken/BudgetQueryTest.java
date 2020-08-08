package com.odde.securetoken;

import org.junit.jupiter.api.Test;

import java.time.Month;

import static java.time.LocalDate.of;
import static java.time.Month.MAY;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BudgetQueryTest {

    BudgetRepo stubBudgetRepo = mock(BudgetRepo.class);
    BudgetService budgetService = new BudgetService(stubBudgetRepo);

    @Test
    public void no_budget() {
        givenBudgets();

        int actual = budgetService.query(of(2020, MAY, 3), of(2020, MAY, 3));

        assertEquals(0, actual);
    }

    @Test
    public void start_end_is_same_date() {
        givenBudgets(budget(2020, MAY, 310));

        int actual = budgetService.query(of(2020, MAY, 3), of(2020, MAY, 3));

        assertEquals(10, actual);
    }

    @Test
    public void start_end_is_two_dates() {
        givenBudgets(budget(2020, MAY, 310));

        int actual = budgetService.query(of(2020, MAY, 3), of(2020, MAY, 4));

        assertEquals(20, actual);
    }

    private Budget budget(final int year, final Month month, final int amount) {
        return new Budget() {{
            setMonth(of(year, month, 1));
            setAmount(amount);
        }};
    }

    private void givenBudgets(Budget... budgets) {
        when(stubBudgetRepo.findAll()).thenReturn(asList(budgets));
    }
}
