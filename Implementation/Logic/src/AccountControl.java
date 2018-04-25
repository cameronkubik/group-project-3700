//Account Control

public class AccountControl {
    // Member variables
    Account sessionAccount;

    public static void buildSessionAccount() {
        Printer.pr("To begin, please create an account.");
        Printer.pr("Fill out the following form:");
        //prompt user for acct info
        String username = Printer.query("Username:", String);
        String email = Printer.query("Email:", String);
        String phoneNumber = Printer.query("10-digit Phone Number (no spaces no hyphens)", String);
        String ssn = Printer.query("Sample Social Security Number:", String);
        String fullName = Printer.query("First and Last Name", String);

        Account sessionAccount = new Account(username, email, phoneNumber, ssn, fullName);
    }
}
