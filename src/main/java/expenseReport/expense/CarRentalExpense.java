package expenseReport.expense;

import expenseReport.Expense;

public class CarRentalExpense extends Expense {
    public CarRentalExpense(int amount) {
        super(amount);
    }

    @Override
    public boolean isOverage() {
        return false;
    }

    @Override
    public boolean isMealExpense() {
        return false;
    }
}
