// Print Class
// Provides classes that make it easy and efficient to print text and data to stdout
import java.util.Scanner;

public class Printer {
    // Using Scanner for Getting Input from User
    static Scanner userInput = new Scanner(System.in);

    public static void pr(String output) {
        if(output != null && output != "") {
            System.out.println(output + "\n");
        } else {
            if (Main.devMode) {
                System.out.println("ERROR: printer received null parameter");
            }
        }
    }

    public static void displayOpening() {
        pr("\n*******************");
        pr("Welcome to Cash Stash!");

        if(Main.devMode) {
            pr("[Entering in DEV MODE]");
        }
    }

    public static void displayClosing() {
        pr("\nClosing Cash Stash...");
        pr("*******************");
    }

    public static String query(String prompt) {
        pr(prompt);
        return userInput.nextLine();

    }
}
