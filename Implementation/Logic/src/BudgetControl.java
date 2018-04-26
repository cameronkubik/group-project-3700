//package com.cmk;
// BudgetControl class

import java.util.ArrayList;

public class BudgetControl {

    public static Float income;
    public static Float expendableIncome;
    public static Float maxExpenses;
    public static Float savings;

    public static void creatBudget() {
        // Start budget prompt
        Printer.pr("To create a budget, please fill out the following form.", 2);
        //Collect budget data
        displayBudgetForm();

        calculateExpenses();

        displayBudgetResults();
    }

    private static void displayBudgetForm() {
        String rawIncome = Printer.query("Monthly Income:", 1);
        income = Float.parseFloat(rawIncome);

        String rawExpendable = Printer.query("How much of this income do you want to be expendable?\n", 0);
        expendableIncome = Float.parseFloat(rawExpendable);
        //TODO error check to make sure values are valid

        String rawSavings = Printer.query("How much do you wish to save each month?\n", 0);
        savings = Float.parseFloat(rawSavings);
    }

    private static void calculateExpenses() {
        maxExpenses = income - savings - expendableIncome;
    }

    private static void displayBudgetResults() {
        Printer.pr("Calculating Budget...", 2);

        String username = AccountControl.getUser().getUsername();
        Printer.pr(username + "'s personal Monthly Budget:'", 1);
        Printer.prForm("Income", income.toString());
        Printer.prForm("Expendable", expendableIncome.toString());
        Printer.prForm("Savings", savings.toString());
        Printer.prForm("Expenses", maxExpenses.toString());

        Printer.pr("\nMonitoring account transactions for Budget quota.", 2);
    }

}
