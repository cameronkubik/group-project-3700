//package com.cmk;
// BudgetControl class

import java.util.ArrayList;

public class BudgetControl {

    private static Budget budget;

    public static void createBudget() {
        // Start budget prompt
        Printer.pr("To create a budget, please fill out the following form.", 2);
        //Collect budget data
        displayBudgetForm();

        displayBudget();
    }

    private static void displayBudgetForm() {
        String rawIncome = Printer.query("Monthly Income:", 1);
        Float income = Float.parseFloat(rawIncome);

        String rawExpendable = Printer.query("How much of this income do you want to be expendable?\n", 0);
        Float expendableIncome = Float.parseFloat(rawExpendable);
        //TODO error check to make sure values are valid

        String rawSavings = Printer.query("How much do you wish to save each month?\n", 0);
        Float savings = Float.parseFloat(rawSavings);

        budget = new Budget(income, expendableIncome, savings);
    }

    private static void displayBudget() {
        String username = AccountControl.getUser().getUsername();

        Printer.pr(username + "'s personal Monthly Budget:", 1);

        budget.print();

        Printer.pr("\nMonitoring account transactions for Budget quota.", 2);
    }

    public static Budget getBudget() {
        return budget;
    }

}
