// Author:  Cameron Kubik
// Date: April 24, 2018
// Cash Stash, Financial Management Application

public class Main {
    // Variable to easily toggle debug features
    public static boolean devMode = true;

    public static void main(String[] args) {
        Printer.displayOpening();
        AccountControl.init();
        Printer.displayClosing();
    }
}
