package rockpaperscissors;

import java.util.Arrays;
import java.util.Scanner;

/***
 * UserInterface Class
 */
public class UserInterface {

    private final Scanner scanner;
    private final GameManager gameManager;

    /**
     * Constructor
     * @param scanner           Standard scanner
     * @param gameManager       GameManager class object
     */
    public UserInterface(Scanner scanner, GameManager gameManager) {
        this.scanner = scanner;
        this.gameManager = gameManager;
    }

    /**
     * Starts the UI
     */
    public void start() {

        // Greet user
        System.out.print("Enter your name: > ");
        String name = this.scanner.nextLine();
        System.out.println("Hello, " + name + "\n");

        // Get options
        System.out.print("Enter options: > ");
        String userPieces = this.scanner.nextLine().toLowerCase();
        String[] pieces = userPieces.split(",");
        if (userPieces.equals("default")) {
            this.gameManager.setDefaultPlayableCpuOptions();
        } else if (!areValidOptions(pieces)) {
            System.out.println("Invalid options.\n");
            return;
        } else {
            this.gameManager.setPlayableCpuOptions(pieces);
        }
        System.out.println("\nOkay, let's start!");
        System.out.println("Available options: ");
        for (String option: this.gameManager.getPlayableCpuOptions()) {
            System.out.print(option + " ");
        }
        System.out.println();

        // Main loop
        while (true) {
            System.out.print("\n> ");
            String userChoice = this.scanner.nextLine();

            // Exit and show rating if user wants
            if (userChoice.equals("!exit")) {
                System.out.println("Bye!");
                break;
            } else if (userChoice.equals("!rating")) {
                System.out.println("Your rating: " + this.gameManager.getUserRating() + "\n");
                continue;
            } else if (!Arrays.asList(this.gameManager.getPlayableCpuOptions()).contains(userChoice)) {
                System.out.println("Invalid input.\n");
                continue;
            }

            // Get game result from the gameManager
            this.gameManager.getGameResult(userChoice.toLowerCase());
        }
    }

    /**
     * Checks if user input are valid options for the game
     * @param pieces        User input as String[] Array
     * @return              Returns result as Boolean
     */
    public boolean areValidOptions(String[] pieces) {
        boolean isValid = true;
        String[] allOptions = this.gameManager.getAllCpuOptions();

        for (String option : pieces) {
            if (!Arrays.asList(allOptions).contains(option.toLowerCase())) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}
