package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * UserInterface Class
 */
public class UserInterface {

    private final Checker checker;
    private final Scanner scanner;
    private final Score score;

    /**
     * Constructor
     * @param checker       Checker object
     * @param scanner       Scanner object
     * @param score         Score object
     */
    public UserInterface(Checker checker, Scanner scanner, Score score) {

        this.checker = checker;
        this.scanner = scanner;
        this.score = score;
    }

    /**
     * Starts the UI
     * @param args              String[] Array of command-line arguments
     * @throws IOException      Throws IOException if it cannot open file, handled in Main
     */
    public void start(String[] args) throws IOException {
        String readSentence = new String(Files.readAllBytes(Paths.get(args[0])));
        System.out.print(this.checker.showProperties(readSentence));
        System.out.print("\nEnter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String userInput = this.scanner.nextLine().toLowerCase();
        System.out.println(this.score.selectScores(userInput, readSentence));
    }
}
