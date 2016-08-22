package expenseReport.expense;

import expenseReport.Expense;
import org.junit.Test;

import static org.junit.Assert.*;

public class DinnerExpenseTest extends ExpenseTest {
    @Override
    protected Expense makeExpense(int amount) {
        return new DinnerExpense(amount);
    }

    @Test
    public void isOverage_IfAmountOver5000() throws Exception {
        assertNotOverage(0);
        assertNotOverage(50_00);

        assertIsOverage(50_01);
        assertIsOverage(999_99);
    }

    @Test
    public void isAlwaysMealExpense() throws Exception {
        assertIsMealExpense();
    }
}
