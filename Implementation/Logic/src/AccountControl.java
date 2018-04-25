//Account Control

public class AccountControl {
    // Member variables
    private static Account currentUser;

    public static void buildSessionAccount() {
        Printer.pr("To begin, please create an account.");
        Printer.pr("Fill out the following form:");
        //prompt user for acct info
        String username = Printer.query("Username:");
        String email = Printer.query("Email:");
        String phoneNumber = Printer.query("10-digit Phone Number (no spaces no hyphens)");
        String ssn = Printer.query("Sample Social Security Number:");
        String fullName = Printer.query("First and Last Name");

        Account currentUser = new Account(username, email, phoneNumber, ssn, fullName);
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

}
