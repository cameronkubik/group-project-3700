//package com.cmk;
// BudgetControl class

import java.util.ArrayList;

public class BudgetControl {

    public static Float income;
    public static Float expendableIncome;
    public static Float expenses;
    public static Float savings;

    public static void creatBudget() {
        // Start budget prompt
        Printer.pr("To create a budget, please fill out the following form.", 2);
        //Begin collecting data
        String rawIncome = Printer.query("Monthly Income:", 1);
        income = Float.parseFloat(rawIncome);

        String rawSavings = Printer.query("How much do you wish to save each month?\n", 0);
        savings = Float.parseFloat(rawSavings);
        
    }

}
