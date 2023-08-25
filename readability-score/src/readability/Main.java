package readability;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Instantiate checker object from Checker class to pass in UserInterface object constructor
        Checker checker = new Checker();
        Scanner scanner = new Scanner(System.in);
        Score score = new Score(checker);

        // Instantiate UserInterface object
        UserInterface ui = new UserInterface(checker, scanner, score);

        // Try to start UI and handle IOException
        try {
            ui.start(args);
        } catch (IOException e) {
            System.out.println("Cannot read file: " + args[0]);
        }
    }
}
