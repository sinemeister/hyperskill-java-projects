package rockpaperscissors;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * GameManager Class
 */
public class GameManager {

    private final String[] allCpuOptions;
    private String[] playableCpuOptions;
    private final Random random;
    private final ArrayList<String> userRatings;
    private int userRating;
    private final OptionLinks optionLinks;

    /**
     * Constructor
     * Parameterless constructor
     * Sets class variable
     */
    public GameManager() {
        this.allCpuOptions = new String[] {
                "rock", "fire", "scissors", "snake", "human", "tree", "wolf", "sponge", "paper", "air", "water",
                "dragon", "devil", "lightning", "gun"};
        this.random = new Random();
        this.userRatings = new ArrayList<>();
        this.optionLinks = new OptionLinks();
    }

    /**
     * Getter
     * @return      Returns class variable cpuOptions as String[] Array
     */
    public String[] getAllCpuOptions() {
        return this.allCpuOptions;
    }

    /**
     * Getter
     * @return      Returns class variable playableCpuOptions as String[] Array
     */
    public String[] getPlayableCpuOptions() {
        return this.playableCpuOptions;
    }

    /**
     * Setter
     * Sets class variable playableCpuOptions
     * @param userPieces        String[] Array user input
     */
    public void setPlayableCpuOptions(String[] userPieces) {
        this.playableCpuOptions = new String[userPieces.length];

        for (int i = 0; i < userPieces.length; i++) {
            this.playableCpuOptions[i] = userPieces[i];
        }
    }

    /**
     * Setter
     * Sets class variable playableCpuOptions to default if user does not specify options
     */
    public void setDefaultPlayableCpuOptions() {
        this.playableCpuOptions = new String[] {"rock", "paper", "scissors"};
    }

    /**
     * Evaluates game result
     * @param userChoice        String literal of the user input read in UI
     */
    public void getGameResult(String userChoice) {
        String cpuChoice = this.playableCpuOptions[this.random.nextInt(this.playableCpuOptions.length)];
        this.optionLinks.setAllOptions(this.playableCpuOptions);
        this.optionLinks.setOptionsToEvaluate(userChoice);

        if (this.optionLinks.evaluate(userChoice, cpuChoice) == 0) {
            getDraw(cpuChoice);
            return;
        } else if (this.optionLinks.evaluate(userChoice, cpuChoice) < 0) {
            getCpuWin(cpuChoice);
            return;
        }
        getUserWin(cpuChoice);
    }

    /**
     * Getter
     * @return      Returns class variable userRating as Integer
     */
    public int getUserRating() {
        return this.userRating;
    }

    /**
     * Prints draw message
     * @param cpuChoice     String literal of the CPU choice
     */
    public void getDraw(String cpuChoice) {
        System.out.println("It is a draw! (The computer chose " + cpuChoice + ")\n");
        this.userRating += 50;
    }

    /**
     * Prints CPU win message
     * @param cpuChoice     String literal of the CPU choice
     */
    public void getCpuWin(String cpuChoice) {
        System.out.println("Sorry, but the computer chose " + cpuChoice + "\n");
    }

    /**
     * Prints user win message
     * @param cpuChoice     String literal of the CPU choice
     */
    public void getUserWin(String cpuChoice) {
        System.out.println("Well done. The computer chose " + cpuChoice + " and failed!\n");
        this.userRating += 100;
    }
}
