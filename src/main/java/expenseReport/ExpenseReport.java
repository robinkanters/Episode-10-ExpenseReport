package expenseReport;

import expenseReport.util.ExpenseNamer;

import java.util.ArrayList;
import java.util.List;

public class ExpenseReport {
    private ReportPrinter printer;
    private List<Expense> expenses = new ArrayList<>();
    private int total = 0;
    private int mealExpenses = 0;

    public ExpenseReport(ReportPrinter printer) {
        this.printer = printer;
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void printReport() {
        printHeader();
        printExpenses();
        printTotals();
    }

    private void printHeader() {
        printer.print("Expenses " + getDate() + "\n");
    }

    private void printExpenses() {
        for (Expense expense : expenses) {
            printExpense(expense);
        }
    }

    private void printExpense(Expense expense) {
        boolean overage = expense.isOverage();
        String name = getExpenseName(expense);
        printExpenseLine(name, expense, overage);

        total += expense.amount;
        mealExpenses += expense.isMealExpense() ? expense.amount : 0;
    }

    private String getExpenseName(Expense expense) {
        return new ExpenseNamer().getName(expense);
    }

    private void printTotals() {
        printer.print(String.format("\nMeal expenses $%.02f", mealExpenses / 100.0));
        printer.print(String.format("\nTotal $%.02f", total / 100.0));
    }

    private void printExpenseLine(String name, Expense expense, boolean isOverage) {
        String overageIndicator = isOverage ? "X" : " ";
        printer.print(String.format("%s\t%s\t$%.02f\n", overageIndicator, name, convertPenniesToDollars(expense)));
    }

    private double convertPenniesToDollars(Expense expense) {
        return expense.amount / 100.0;
    }

    private String getDate() {
        return "9/12/2002";
    }
}
