package expenseReport.expense;

import expenseReport.Expense;

public class DinnerExpense extends Expense {
    public DinnerExpense(int amount) {
        super(amount);
    }

    @Override
    public boolean isOverage() {
        return amount > 5000;
    }

    @Override
    public boolean isMealExpense() {
        return true;
    }
}
