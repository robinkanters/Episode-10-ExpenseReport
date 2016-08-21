package expenseReport.util;

import expenseReport.Expense;
import expenseReport.expense.*;

public class ExpenseNamer {
    public String getName(Expense expense) {
        if (expense instanceof DinnerExpense) {
            return "Dinner";
        } else if (expense instanceof BreakfastExpense) {
            return "Breakfast";
        } else if (expense instanceof CarRentalExpense) {
            return "Car Rental";
        }
        return "TILT";
    }
}
