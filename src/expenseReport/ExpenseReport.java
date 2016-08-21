package expenseReport;

import expenseReport.util.ExpenseNamer;

import java.util.ArrayList;
import java.util.List;

public class ExpenseReport {
    private List<Expense> expenses = new ArrayList<Expense>();
    private int total = 0;
    private int mealExpenses = 0;

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void printReport(ReportPrinter printer) {
        printHeader(printer);
        printExpenses(printer);
        printTotals(printer);
    }

    private void printHeader(ReportPrinter printer) {
        printer.print("Expenses " + getDate() + "\n");
    }

    private void printExpenses(ReportPrinter printer) {
        for (Expense expense : expenses) {
            printExpense(printer, expense);
        }
    }

    private void printExpense(ReportPrinter printer, Expense expense) {
        boolean overage = expense.isOverage();
        String name = getExpenseName(expense);
        mealExpenses += expense.isMealExpense() ? expense.amount : 0;

        printExpenseLine(printer, name, expense, overage);
        total += expense.amount;
    }

    private String getExpenseName(Expense expense) {
        return new ExpenseNamer().getName(expense);
    }

    private void printTotals(ReportPrinter printer) {
        printer.print(String.format("\nMeal expenses $%.02f", mealExpenses / 100.0));
        printer.print(String.format("\nTotal $%.02f", total / 100.0));
    }

    private void printExpenseLine(ReportPrinter printer, String name, Expense expense, boolean isOverage) {
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
