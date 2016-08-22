package expenseReport.expense;

import expenseReport.Expense;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarRentalExpenseTest extends ExpenseTest {
    @Override
    protected Expense makeExpense(int amount) {
        return new CarRentalExpense(amount);
    }

    @Test
    public void isNeverOverage() throws Exception {
        assertNotOverage(0);
        assertNotOverage(10_00);
        assertNotOverage(10000_00);
        assertNotOverage(10000000_00);
    }

    @Test
    public void isNotMealExpense() throws Exception {
        assertNotMealExpense();
    }
}
