package expenseReport.expense;

import expenseReport.Expense;

public class BreakfastExpense extends Expense {
    public BreakfastExpense(int amount) {
        super(amount);
    }

    @Override
    public boolean isOverage() {
        return amount > 1000;
    }

    @Override
    public boolean isMealExpense() {
        return true;
    }
}
