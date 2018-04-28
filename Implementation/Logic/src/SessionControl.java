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
        return activeSession;
    }

    private static void getCredentials() {
        Printer.pr("Please login.", 2);

        username = Printer.query("Username:", 1);
        password = Printer.query("Password:", 2);
    }
}
