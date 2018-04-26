//package com.cmk;
//Account Control

public class AccountControl {
    // Member variables
    private static Account currentUser;

    public static void buildSessionAccount() {
        Printer.pr("To begin, please create an account.", 1);
        Printer.pr("Fill out the following form:", 2);
        //prompt user for acct info
        String username = Printer.query("Username:", 1);
        String password = Printer.query("Password:", 1);
        String email = Printer.query("Email:", 2);
        String phoneNumber = Printer.query("Phone Number:", 1);
        String ssn = Printer.query("Sample SSN:", 1);
        String fullName = Printer.query("Full Name:", 1);

        currentUser = new Account(username, password, email, phoneNumber, ssn, fullName);

        Printer.pr("Your account has been created!", 2);
    }

    public static Account getUser() {
        return currentUser;
    }

    public static void setUser(String username, String password) {
        //TODO
    }

    public static void createAccount(String username, String password) {
        //TODO
    }

    public static void deleteAccount(int userId) {
        //TODO
    }

    public static boolean checkUsernameAvailibility(String username) {
        //TODO
        return false;
    }

    public static boolean verifyCredentials(String username, String password) {
        boolean user = username.equals(currentUser.getUsername());
        boolean pw = password.equals(currentUser.getPassword());

        if(user && pw) {
            return true;
        }

        return false;
    }
}
