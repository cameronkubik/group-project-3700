//package com.cmk;
//Account Control

public class AccountControl {
    // Member variables
	private static int accountIDIndex = 0;
    private static Account currentUser = new Account();

    public static Account getUser() {
        return currentUser;
    }
    public static int getAccountIDIndex() {
    	return accountIDIndex;
    }
    public static void setUser(Account user) {
        currentUser = user;
    }
    public static void setAccountIDIndex(int id) {
    	accountIDIndex = id;
    }

    public static boolean createAccount() {
        Printer.pr("\n********** New Account Information **********", 1);
        
        String username = Printer.query("Username:", 1);
        String password = Printer.query("Password:", 1);
        String email = Printer.query("Email:", 2);
        String phoneNumber = Printer.query("Phone Number:", 1);
        String ssn = Printer.query("Sample SSN:", 1);
        String fullName = Printer.query("Full Name:", 1);

        if (checkUsernameAvailibility(username)) {
            currentUser = new Account(accountIDIndex, username, password, email, phoneNumber, ssn, fullName);
            DatabaseManager.saveAccount(currentUser.toCSV());            
            accountIDIndex++;
            return true;
        }
        else {
        	return false;
        }

    }
    public static void manageAccount() {
    	Printer.pr("\nTo skip editing a field just leave it blank and press Enter.", 1);
    	
        String email = Printer.query("Email:", 2);
        String phoneNumber = Printer.query("Phone Number:", 1);
        String ssn = Printer.query("Sample SSN:", 1);
        String fullName = Printer.query("Full Name:", 1);
        
        if (!email.equals("")) { currentUser.setEmail(email); }
        if (!phoneNumber.equals("")) { currentUser.setPhoneNumber(phoneNumber); }
        if (!ssn.equals("")) { currentUser.setSsn(ssn); }
        if (!fullName.equals("")) { currentUser.setFullName(fullName); }
        
        DatabaseManager.deleteAccount(currentUser.getID());
        DatabaseManager.saveAccount(currentUser.toCSV());
    }

    public static boolean deleteAccount() {
        if (Printer.query("\nPlease enter your password to delete your account: ", 1).equals(currentUser.getPassword())) {
        	DatabaseManager.deleteAccount(currentUser.getID());
        	SessionControl.logout();
        	return true;
        }
        else {
        	Printer.pr("Password Incorrect. Account has not been deleted.", 1);
        	return false;
        }
    }

    public static boolean checkUsernameAvailibility(String username) {
        return !DatabaseManager.findAccount(username);
    }
    public static boolean verifyCredentials(String username, String password) {
    	String accountData = DatabaseManager.findAccount(username, password);
    	if (accountData.equals("")) {
    		return false; 
    	}
    	else {
    		currentUser = new Account(accountData);
    		TransactionControl.loadTransactions(currentUser.getID());
    		return true;
    	}    
    }

    public static boolean openMenu() {    	
    	String response = "0";
    	do {
        	Printer.newlines(1);
        	Printer.pr("********** Account Menu Options **********", 1);
        	Printer.pr("1) Manage Account Details", 1);
        	Printer.pr("2) Link External Account", 1);
        	Printer.pr("3) Delete Account", 1);
        	Printer.pr("4) Return to Main Menu", 1);        	
        	response = Printer.query("Choose a menu option: ", 0);
        	
        	switch (response) {
	        	case "1":
	        		manageAccount();
	        		break;
	        	case "2":
	        		break;
	        	case "3":
	        		if (deleteAccount()) { return false; }
	        		break;
	        	case "4":
	        		Printer.newlines(1);
	        		break;
        	}
    		
    	} while (!response.equals("4"));
    	
    	return true;
    }
}
