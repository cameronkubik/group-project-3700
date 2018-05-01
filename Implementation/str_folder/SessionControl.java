//package com.cmk;
//Session Control Class

public class SessionControl {
    // Member variables
    private static String username;
    private static String password;
    public static boolean activeSession = false;

    public static boolean login() {
        getCredentials();

        activeSession = AccountControl.verifyCredentials(username, password);

        if(!activeSession) {
            Printer.pr("Login Failed.", 0);
        }
        else {
        	Printer.pr("Login Successful!", 2);        	
        }
        
        return activeSession;
    }
    public static boolean logout() {
    	activeSession = false;
    	return true;
    }

    private static void getCredentials() {
        Printer.pr("Enter your username and password to login.", 1);

        username = Printer.query("Username:", 1);
        password = Printer.query("Password:", 1);
        
    }
}
