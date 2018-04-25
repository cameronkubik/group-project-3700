// Print Class
// Provides classes that make it easy and efficient to print text and data to stdout

public class Printer {

    public static void pr(String output) {
        if(output != null && output != "") {
            System.out.println(output);
        } else {
            if (Main.devMode) {
                System.out.println("ERROR: printer received null parameter");
            }
        }
    }

    public static void displayOpening() {
        String open = "\n*******************\nWelcome to Cash Stash!\n";
        System.out.println(open);

        if(Main.devMode) {
            System.out.println("[Entering in DEV MODE]\n");
        }
    }

    public static void displayClosing() {
        String close = "\nClosing Cash Stash...\nGoodbye\n*******************\n";
        System.out.println(close);
    }
}
