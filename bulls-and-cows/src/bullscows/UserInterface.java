package bullscows;

import java.util.Scanner;

/**
 * UserInterface Class
 */
public class UserInterface {

    private final Grader grader;
    private final CodeGenerator codeGenerator;
    private final Scanner scanner;
    private int turn;

    /**
     * Constructor
     * Sets class variables
     * @param grader            Grader object to be used
     * @param codeGenerator     CodeGenerator object to be used
     * @param scanner           Scanner object to be used
     */
    public UserInterface(Grader grader, CodeGenerator codeGenerator, Scanner scanner) {
        this.grader = grader;
        this.scanner = scanner;
        this.codeGenerator = codeGenerator;
        this.turn = 1;
    }

    /**
     * Starts the UI
     */
    public void start() {
        // Ask the user the length of the secret code
        System.out.println("Please, enter the secret code's length (Q to quit):");
        System.out.print("> ");
        String digitUserInputAsString = scanner.nextLine();

        if (digitUserInputAsString.equalsIgnoreCase("q")) {
            System.out.println("Thanks for playing!");
            return;
        }
        int digits; // Declare an int type variable before try-catch block

        /* Try and typecast the read value
           if NumberFormatException is thrown, quit
           else proceed
         */
        try {
            digits = Integer.parseInt(digitUserInputAsString);
        } catch (NumberFormatException e) {
            System.out.println("Error: " + digitUserInputAsString + " isn't a valid number.");
            return;
        }

        // If read length is not valid, display an error and quit
        if (digits < 0 || digits > 36) {
            System.out.println("Error: can't generate a secret code with a length of " + digits +
                    " because there aren't enough unique digits.");
            return;
        } else if (digits == 0) {
            System.out.println("Error: can't generate a secret code with a length of 0.");
            return;
        }

        // Asks the user the possible symbols for the code
        System.out.println("Input the number of possible symbols in the code (Q to quit):");
        System.out.print("> ");
        String symbolUserInputAsString = scanner.nextLine();

        if (symbolUserInputAsString.equalsIgnoreCase("q")) {
            System.out.println("Thanks for playing!");
            return;
        }
        int possibleSymbols; // Declare an int type variable before try-catch block

        /* Try and typecast the read value
           if NumberFormatException is thrown, quit
           else proceed
         */
        try {
            possibleSymbols = Integer.parseInt(symbolUserInputAsString);
        } catch (NumberFormatException e) {
            System.out.println("Error: " + symbolUserInputAsString + " isn't a valid number.");
            return;
        }

        // If read possibleSymbol length is not valid, display an error and quit
        if (possibleSymbols < 10 || possibleSymbols > 36) {
            System.out.println("Error: can't generate a secret code with " + possibleSymbols +
                    " symbols because there aren't enough unique symbols.");
            return;
        } else if (possibleSymbols < digits) {
            System.out.println("Error: can't generate a secret code with a length of " + digits +
                    " with " + possibleSymbols + " unique symbols.");
            return;
        }

        /* Else set read inputs as the codeGenerator object's digits and possibleSymbols variables
           and generate a random secret code
        */
        this.codeGenerator.setDigits(digits);
        this.codeGenerator.setPossibleSymbols(possibleSymbols - 10);
        this.codeGenerator.setAllPossibleSymbols(); // Generate ArrayList here
        this.grader.setSecretCode(String.valueOf(this.codeGenerator.generate())); // Generate the code

        // Print start message to indicate the beginning of the game
        printStartMessage(possibleSymbols, digits);

        // Main game loop
        while (true) {

            // Display turn number and reads user guess
            System.out.println("Turn " + getTurn() + ":");
            System.out.print("> ");
            String guessedCode = this.scanner.nextLine();

            // Quit if the user wants to
            if (guessedCode.equalsIgnoreCase("q")) {
                System.out.println("Thanks for playing!");
                break;
            }

            // Check if user guess is valid
            if (!isValidGuess(guessedCode)) {
                continue;
            }
            // If valid, grade the guess
            System.out.println(this.grader.grade(guessedCode));

            // If the user guessed correct, display win message and breaks out of the loop
            if (this.grader.getBulls() == digits) {
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }

            /* Else increment turn number by 1
               and set both cows and bulls variables of Grader object as 0 to
               be evaluated again in the next round
             */
            this.turn++;
            this.grader.setCows(); // Sets 0 by default
            this.grader.setBulls(); // Sets 0 by default
        }
    }

    /**
     * Checks if the user provides a valid guess
     * Compares user guess' length against the actual secret code's length
     * @param guessedCode   String literal of the user guess
     * @return              Result of the comparison as Boolean
     */
    public boolean isValidGuess(String guessedCode) {
        return guessedCode.length() == this.grader.getSecretCode().length();
    }

    /**
     * Prints the start message after everything is set
     * Dynamically changes the current possibility of the secret code depending on user input
     * @param possibleSymbols       User input possibleSymbols as Integer
     * @param digits                User input digits as Integer
     */
    public void printStartMessage(int possibleSymbols, int digits) {
        // Print as many stars as digits to indicate the secret code
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < digits; i++) {
            System.out.print("*");
        }

        // Print current possibility of the secret code
        if (possibleSymbols == 10) {
            System.out.println(" (0-9).");
            return;
        } else if (possibleSymbols == 11) {
            System.out.println(" (0-9, a).");
            return;
        }
        /* Subtract 11 from 97 + possibleSymbols (ASCII lowercase a + possibleSymbols)
           as 10 is all the numbers that are also included in possibleSymbols
           and 1 is to include the last possible letter
         */
        System.out.print(" (0-9, a-" + (char) (97 + possibleSymbols - 10 - 1) + ").");
        System.out.println();
        System.out.println("Okay, let's start a game!");
    }

    /**
     * Getter
     * @return      Class variable turn as Integer
     */
    public int getTurn() {
        return this.turn;
    }
}
