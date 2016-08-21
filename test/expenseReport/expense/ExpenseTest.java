package expenseReport.expense;

import expenseReport.Expense;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class ExpenseTest {
    @Test
    public void assertConstructorPlacesAmountInPublicField() throws Exception {
        assertEquals(0, makeExpense(0).amount);
        assertEquals(5, makeExpense(5).amount);
    }

    protected void assertIsOverage(int amount) {
        assertTrue(getIsOverageForNewExpense(amount));
    }

    protected void assertNotOverage(int amount) {
        assertFalse(getIsOverageForNewExpense(amount));
    }

    protected void assertIsMealExpense() {
        assertTrue(getIsMealExpenseForNewExpense(0));
    }

    protected void assertNotMealExpense() {
        assertFalse(getIsMealExpenseForNewExpense(0));
    }

    private boolean getIsOverageForNewExpense(int amount) {
        return makeExpense(amount).isOverage();
    }

    private boolean getIsMealExpenseForNewExpense(int amount) {
        return makeExpense(amount).isMealExpense();
    }

    protected abstract Expense makeExpense(int amount);
}
