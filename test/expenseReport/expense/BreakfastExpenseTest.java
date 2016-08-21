package expenseReport.expense;

import org.junit.Test;

import static org.junit.Assert.*;

public class BreakfastExpenseTest extends ExpenseTest {
    protected BreakfastExpense makeExpense(int amount) {
        return new BreakfastExpense(amount);
    }

    @Test
    public void isOverage_IfAmountOver1000() throws Exception {
        assertNotOverage(0);
        assertNotOverage(10_00);

        assertIsOverage(10_01);
        assertIsOverage(999_99);
    }

    @Test
    public void isMealExpense() throws Exception {
        assertIsMealExpense();
    }

}
