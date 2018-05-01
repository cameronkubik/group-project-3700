//package com.cmk;
// Author:  Cameron Kubik
// Date: April 24, 2018
// Cash Stash, Financial Management Application

public class Main {
    // Variable to easily toggle debug features
    public static boolean devMode = false;

    public static void main(String[] args) {
    	Printer.displayOpening(); 
    	
    	if (!DatabaseManager.setupDBManager()) {
    		Printer.pr("Database setup failed!", 1);
    		Printer.displayClosing();
    	}
    	else {     
	        while (true) {
	        	String hasAccount = Printer.query("Do you already have a Cash Stash account? (y/n): ", 0); 
	        	Printer.newlines(1);
	        	if (hasAccount.equals("n")) {
	        		while (!AccountControl.createAccount()) {
	        			Printer.pr("Please choose a different username and try again.", 2);
	        		}
	        		
	        		Printer.pr("Your account has been created!", 2);
	        	}
	        	
	        	boolean canProceed = SessionControl.login();
	            while(!canProceed) {
	                canProceed = SessionControl.login();
	            }      	
	        	
		        String response = "";
		        do {
		            Printer.displayMainMenu();
		        	response = Printer.query("Choose a menu option: ",  0);
		        	switch (response) {
			        	case "1": 
			        		TransactionControl.createTransaction();
			        		Printer.pr("Transaction Saved!", 2);
			        		break;
			        	case "2":
			        		BudgetControl.createBudget();
			        		break;
			        	case "3":
			        		CashFlowControl.createCashFlow();
			        		break;
			        	case "4": 
			        		SlippageControl.calculateSlippage();
			        		break;
			        	case "5": 
			        		if (!AccountControl.openMenu()) {
			        			response = "7";
			        		}
			        		break;
			        	case "6": 
			        		DataControl.openMenu();
			        		break;
			        	case "7":	        		
			        		SessionControl.logout();
			        		response = "7";
			        		break;
		        	}
		        } while (!response.equals("7"));
		        

		        Printer.displayClosing();
		        System.exit(0);
	        }
	
    	}
    }
    
}
