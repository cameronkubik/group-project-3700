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
}
