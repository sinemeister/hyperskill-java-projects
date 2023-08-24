package rockpaperscissors;

import java.util.ArrayList;

/**
 * OptionLinks Class
 */
public class OptionLinks {

    private String[] allOptions;
    private ArrayList<String> winAgainst;
    private ArrayList<String> loseAgainst;

    /**
     * Setter
     * Sets class variable allOptions
     * @param allPlayableOptions        String[] Array that user inputs
     */
    public void setAllOptions(String[] allPlayableOptions) {
        this.allOptions = allPlayableOptions;
        this.winAgainst = new ArrayList<>();
        this.loseAgainst = new ArrayList<>();
    }

    /**
     * Sets class variable winAgainst and loseAgainst lists depending on the user choice
     * @param userChoice        String literal of user option
     */
    public void setOptionsToEvaluate(String userChoice) {

        int targetIndex = -1;
        for (int i = 0; i < this.allOptions.length; i++) {
            if (this.allOptions[i].equals(userChoice)) {
                targetIndex = i;
                break;
            }
        }

        int halfWayInAllOptions = (this.allOptions.length - 1) / 2;
        for (int i = 0; i < halfWayInAllOptions; i++) {
            this.loseAgainst.add(this.allOptions[(targetIndex + 1 + i) % this.allOptions.length]);
        }

        for (int i = 0; i < halfWayInAllOptions; i++) {
            this.winAgainst.add(this.allOptions[((targetIndex + 1 + this.loseAgainst.size() + i)
                    % this.allOptions.length)]);
        }
    }

    /**
     * Checks who wins for the turn
     * @param userChoice    String literal of user input
     * @param cpuChoice     String literal of CPU choice
     * @return              Returns -1 if CPU wins, 0 if it is a draw, 1 if user wins
     */
    public int evaluate(String userChoice, String cpuChoice) {
        if (userChoice.equals(cpuChoice)) {
            return 0;
        } else if (this.winAgainst.contains(cpuChoice)) {
            return 1;
        }
        return -1;
    }
}
