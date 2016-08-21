package expenseReport;

public abstract class Expense {
    public int amount;

    public Expense(int amount) {
        this.amount = amount;
    }

    public abstract boolean isOverage();
    public abstract boolean isMealExpense();
}
