package bullscows;

/**
 * Grader Class
 */
public class Grader {

    private int bulls;
    private int cows;
    private String secretCode;

    /**
     * Constructor
     * Parameterless constructor
     * Sets class variables
     */
    public Grader() {
        this.bulls = 0;
        this.cows = 0;
        this.secretCode = "";
    }

    /**
     * Checks the given String literal guess against the secret code
     * and returns toString() method
     * @param guessedCode   The String literal of the guessed code that has been read from the user input
     *                      by UserInterface Class
     * @return              Calls toString() method of the class
     */
    public String grade(String guessedCode) {
        /* Check each character of the guessed and the actual secret codes
           and look for cows and bulls matches
         */
        for (int i = 0; i < guessedCode.length(); i++) {
            if (guessedCode.charAt(i) != secretCode.charAt(i) &&
                    secretCode.contains(String.valueOf(guessedCode.charAt(i)))) {
                this.cows++;
            } else if (guessedCode.charAt(i) == secretCode.charAt(i)) {
                this.bulls++;
            }
        }
        return toString();
    }

    /**
     * Getter
     * @return  Class variable bulls
     */
    public int getBulls() {
        return bulls;
    }

    /**
     * Setter
     * Sets class variable bulls to 0
     */
    public void setBulls() {
        this.bulls = 0;
    }

    /**
     * Getter
     * @return  Returns class variable cows as Integer
     */
    public int getCows() {
        return cows;
    }

    /**
     * Setter
     * Sets class variable cows to 0
     */
    public void setCows() {
        this.cows = 0;
    }

    /**
     * Getter
     * @return      Returns class variable secretCode as String literal
     */
    public String getSecretCode() {
        return secretCode;
    }

    /**
     * Setter
     * Sets class variable secretCode to the given String literal
     * @param secretCode    String literal
     */
    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    /**
     * Overrides toString() method of Object class
     * @return      Returns grade depending on the bulls and cows values
     */
    @Override
    public String toString() {
        if (this.bulls > 0 && this.cows > 0) {
            return "Grade: " + this.bulls + " bull(s) and " + this.cows + " cow(s).";
        } else if (this.bulls > 0 && this.cows == 0) {
            return "Grade: "  + this.bulls + " bull(s).";
        } else if (this.cows > 0 && this.bulls == 0) {
            return "Grade: " + this.cows + " cow(s).";
        }
        return "None.";
    }
}
