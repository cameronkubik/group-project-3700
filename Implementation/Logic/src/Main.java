//package com.cmk;
// Author:  Cameron Kubik
// Date: April 24, 2018
// Cash Stash, Financial Management Application

public class Main {
    // Variable to easily toggle debug features
    public static boolean devMode = true;

    public static void main(String[] args) {

        Printer.displayOpening();

        // WORKING
        //AccountControl.buildSessionAccount();
        //boolean canProceed = SessionControl.login();
        //if(!canProceed) { Printer.displayClosing(); }

        //TODO session control query nav options

        // create a budget
        BudgetControl.creatBudget();


        Printer.displayClosing();
    }
}
