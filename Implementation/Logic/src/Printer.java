//package com.cmk;
// Print Class
// Provides classes that make it easy and efficient to print text and data to stdout
import java.util.Scanner;

public class Printer {
    // Using Scanner for Getting Input from User
    static Scanner userInput = new Scanner(System.in);

    public static void pr(String output, int newLines) {
        // error check
        if(output == null || output == "") {
            System.out.println("ERROR: printer received null parameter");
            return;
        }
        //print to console
        System.out.print(output);

        //print newLines
        while(newLines > 0) {
            System.out.print("\n");
            newLines--;
        }

    }

    public static void displayOpening() {
        pr("*******************", 1);
        pr("Welcome to Cash Stash!", 1);

        if(Main.devMode) {
            pr("[Entering in DEV MODE]", 2);
        }
    }

    public static void displayClosing() {
        pr("\nClosing Cash Stash...", 1);
        pr("*******************", 2);
    }

    public static String query(String prompt, int tabs) {
        while(tabs > 0) {
            prompt += "\t";
            tabs--;
        }

        pr(prompt, 0);

        return userInput.nextLine();
    }

    public static void prForm(String label, String value) {
        pr(label + ": ", 0);
        pr("\t\t\t", 0);
        pr(value, 1);
    }

    public static void newlines(int numLines) {
        while (numLines > 0) {
            System.out.println("");
            numLines--;
        }
    }
}
