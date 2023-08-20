package bullscows;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * CodeGenerator Class
 */
public class CodeGenerator {

    private String secretCode;
    private int digits;
    private ArrayList<String> allPossibleSymbols;
    private int possibleSymbols;

    /**
     * Constructor
     * Parameterless constructor
     * Sets class variables
     */
    public CodeGenerator() {

        this.secretCode = "";
        this.digits = 0;
        this.possibleSymbols = 0;
    }

    /**
     * Getter
     * @return      Returns class variable secretCode as Long
     */
    public String getSecretCode() {
        return secretCode;
    }

    /**
     * Getter
     * @return      Returns class variable digits as Integer
     */
    public int getDigits() {
        return this.digits;
    }

    /**
     * Setter
     * Sets class variable digits to the given value if value is in range [0, 10]
     * @param digits    Integer value
     */
    public void setDigits(int digits) {
        if (digits >= 0 && digits <= 36) {
            this.digits = digits;
        }
    }

    /**
     * Getter
     * @return      Returns class variable possibleSymbols as Integer
     */
    public int getPossibleSymbols() {
        return this.possibleSymbols;
    }

    /**
     * Setter
     * Sets class variable possibleSymbols to the given value if value is in range [0, 26]
     * Value cannot be more than 26 as there 26 letters
     * @param value     Integer value
     */
    public void setPossibleSymbols(int value) {
        if (value >= 0 && value <= 26) {
            this.possibleSymbols = value;
        }
    }

    /**
     * Getter
     * @return      Returns class variable allPossibleSymbols as ArrayList<String>
     */
    public ArrayList<String> getAllPossibleSymbols() {
        return this.allPossibleSymbols;
    }

    /**
     * Setter
     * Adds the ArrayList all possible digits in range [0, 9] and all possible lowercase letters'
     * String literal representations using ASCII values depending on the class variable possibleSymbols
     */
    public void setAllPossibleSymbols() {
        this.allPossibleSymbols = new ArrayList<>();

        // Add all numbers in range [0, 9] to the list
        for (int i = 0; i < 10; i++) {
            this.allPossibleSymbols.add(String.valueOf(i));
        }

        // Add all lowercase letters in range [a, a + possibleSymbols] to the list
        for (int i = 97; i < 97 + possibleSymbols; i++) {
            this.allPossibleSymbols.add(String.valueOf((char) i));
        }
    }

    /**
     * Generates random secret code of class variable digits. Uses Random class to find unique numbers and
     * letters from class variable allPossibleSymbols and appends to the string builder
     * which is to be assigned to secretCode
     * @return      Class variable secretCode as String literal
     */
    public String generate() {

        StringBuilder codeToBeReturned = new StringBuilder();
        Random random = new Random();
        int randomIndex = random.nextInt(this.allPossibleSymbols.size());

        // Set first digit of the secret code randomly from the class variable ArrayList<String> allPossibleSymbols
        codeToBeReturned.append(this.allPossibleSymbols.get(randomIndex));

        // If desired length is more than the current length (1) proceed to generate more symbols
        if (codeToBeReturned.length() < digits) {
            while (codeToBeReturned.length() < digits) {
                int index = random.nextInt(this.allPossibleSymbols.size());
                String nextInt = String.valueOf(this.allPossibleSymbols.get(index));

                /* If generated symbol is already in the String literal of string builder
                   continue the loop and generate new one. Else, append the symbol to the string builder
                 */
                if (codeToBeReturned.toString().contains(nextInt)) {
                    continue;
                } else {
                    codeToBeReturned.append(nextInt);
                }
            }
        }
        // Cast the generated code to a Long and return
        this.secretCode = codeToBeReturned.toString();
        return secretCode;
    }

    /**
     * Overrides toString() method of Object class
     * @return      Returns either an error or the secretCode itself depending on the class variable digit
     */
    @Override
    public String toString() {
        if (secretCode.isEmpty()) {
            return "Error: can't generate a secret number with a length of " + digits + " because there aren't enough unique digits.";
        }
        return "The random secret number is " + secretCode;
    }
}
