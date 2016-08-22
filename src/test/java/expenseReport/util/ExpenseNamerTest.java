package expenseReport.util;

import expenseReport.Expense;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpenseNamerTest {
    private ExpenseNamer expenseNamer;

    @Before
    public void setUp() throws Exception {
        expenseNamer = new ExpenseNamer();
    }

    @Test
    public void willReturnTILTWhenGivenUnknownDerivativeOfExpense() throws Exception {
        Expense expense = new Expense(0) {
            public boolean isOverage() {
                return false;
            }

            public boolean isMealExpense() {
                return false;
            }
        };

        assertEquals("TILT", expenseNamer.getName(expense));
    }
}
