package numbers;

/**
 * Number Class
 */
public class Number {

    private long number;
    private final StringBuilder stringBuilder;
    private final String[][] mutuallyExclusivePairs;

    /**
     * Constructor
     * Parameterless constructor
     * Sets class variables
     */
    public Number() {
        this.number = 0;
        this.stringBuilder = new StringBuilder();
        this.mutuallyExclusivePairs = new String[19][];
    }

    /**
     * Setter
     * Sets class variable number to given value if value is non-negative Long
     * @param value     Long value
     */
    public void setNumber(long value) {
        if (value > 0) {
            this.number = value;
        }
    }

    /**
     * Gets class variable number's String literal representation
     * @return      Returns class variable number's String literal representation
     */
    public String getNumberAsString() {
        return String.valueOf(this.number);
    }

    /**
     * Finds and returns the last digit of the class variable number
     * @return      Returns last digit of class variable number as Integer
     */
    public long getNumbersLastDigit() {
        return this.number % 10;
    }

    /**
     * Prepares a String Array with all possible properties
     * @return      Returns all possible properties as String Array
     */
    public String[] getAvailableProperties() {
        return new String[] {"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy", "sunny", "square",
                             "jumping", "happy", "sad"};
    }

    /**
     * Prepares a String Array with all negated possible properties
     * @return      Returns all negated possible properties as String Array
     */
    public String[] getNegAvailableProperties() {
        return new String[] {"-even", "-odd", "-buzz", "-duck", "-palindromic", "-gapful", "-spy", "-sunny", "-square",
                "-jumping", "-happy", "-sad"};
    }

    /**
     * Checks if number is a buzz number or not
     * @return      Comparison value as Boolean
     */
    public boolean isBuzz() {
        return this.number % 7 == 0 || getNumbersLastDigit() == 7;
    }

    /**
     * Checks if number is a duck number or not
     * @return      Returns result as Boolean
     */
    public boolean isDuck() {
        boolean trailingZero = false;

        for (int i = 1; i < String.valueOf(this.number).length(); i++) {
            if (String.valueOf(this.number).charAt(i) == '0') {
                trailingZero = true;
                break;
            }
        }
        return String.valueOf(this.number).charAt(0) != '0' && trailingZero;
    }

    /**
     * Checks if number is a palindromic number or not
     * @return      Returns result as Boolean
     */
    public boolean isPalindromic() {
        // Create new StringBuilder object
        StringBuilder newSB = new StringBuilder(String.valueOf(this.number));
        long reversedNumber;

        // If reversed number is greater than maximum long value, catch exception and return false immediately
        try {
            reversedNumber = Long.parseLong(newSB.reverse().toString());
        } catch (NumberFormatException e) {
            return false;
        }

        return this.number == reversedNumber;
    }

    /**
     * Checks if number is a gapful number or not
     * @return      Returns result as Boolean
     */
    public boolean isGapFul() {

        // Get number's first and last digit and create new integer out of them
        int firstAndLastDigitCombined = Integer.parseInt(getNumberAsString().charAt(0) +
                String.valueOf(getNumbersLastDigit()));

        return this.number >= 100 && this.number % firstAndLastDigitCombined == 0;
    }

    /**
     * Checks if number is a spy number or not
     * @return      Returns result as Boolean
     */
    public boolean isSpy() {
        int sum = 0;
        int product = 1;

        for (int i = 0; i < getNumberAsString().length(); i++) {
            sum += Integer.parseInt(String.valueOf(getNumberAsString().charAt(i)));
        }

        for (int i = 0; i < getNumberAsString().length(); i++) {
            product *= Integer.parseInt(String.valueOf(getNumberAsString().charAt(i)));
        }
        return sum == product;
    }

    /**
     * Checks if number is a sunny number or not
     * @return      Returns result as Boolean
     */
    public boolean isSunny() {
        return Math.sqrt((this.number + 1)) == (int) Math.sqrt((this.number + 1));
    }

    /**
     * Checks if number is a square number or not
     * @return      Returns result as Boolean
     */
    public boolean isSquare() {
        return Math.sqrt(this.number) == (int) Math.sqrt(this.number);
    }

    /**
     * Checks if number is a jumping number or not
     * @return      Returns result as Boolean
     */
    public boolean isJumping() {
        boolean isJumpingNumber = true;

        // Check if number is single-digit
        if (this.number % 10 == this.number) {
            return true;
        }

        // Check if differences between consecutive digits are 1
        for (int i = 0; i < getNumberAsString().length() - 1; i++) {
            if (Math.abs(getNumberAsString().charAt(i) - getNumberAsString().charAt(i + 1)) != 1) {
                isJumpingNumber = false;
                break;
            }
        }
        return isJumpingNumber;
    }

    /**
     * Checks if a number is happy or not
     * @return      Returns result as Boolean
     */
    public boolean isHappy() {
        long slow = this.number;
        long fast = getNext(getNext(this.number));

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    /**
     * Helper for isHappy() method
     * @param n     Long integer value
     * @return      Returns next sum of squares for isHappy() method
     */
    private long getNext(long n) {
        long squareSum = 0;
        while (n > 0) {
            long digit = n % 10;
            squareSum += digit * digit;
            n /= 10;
        }
        return squareSum;
    }

    /**
     * Checks if number is a sad number or not
     * @return      Returns result as Boolean
     */
    public boolean isSad() {
        return !isHappy();
    }

    /**
     * Checks if number is an even number
     * @return      Returns result as Boolean
     */
    public boolean isEven() {
        return this.number % 2 == 0;
    }

    /**
     * Checks if number is an odd number
     * @return      Returns result as Boolean
     */
    public boolean isOdd() {
        return this.number % 2 != 0;
    }

    /**
     * Checks if number is of desired property or not (including excluded properties with a hyphen)
     * @param properties    String[] array of user input properties
     * @return              Returns result as Boolean
     */
    public boolean isDesiredProperty(String[] properties) {
        boolean isDesired = true;

        for (String property: properties) {
            if (property.contains("buzz")) {
                if (property.charAt(0) == '-') {
                    isDesired = isDesired && !isBuzz();
                } else {
                    isDesired = isDesired && isBuzz();
                }
            } else if (property.contains("duck")) {
                if (property.charAt(0) == '-') {
                    isDesired = isDesired && !isDuck();
                } else {
                    isDesired = isDesired && isDuck();
                }
            } else if (property.contains("palindromic")) {
                if (property.charAt(0) == '-') {
                    isDesired = isDesired && !isPalindromic();
                } else {
                    isDesired = isDesired && isPalindromic();
                }
            } else if (property.contains("gapful")) {
                if (property.charAt(0) == '-') {
                    isDesired = isDesired && !isGapFul();
                } else {
                    isDesired = isDesired && isGapFul();
                }
            } else if (property.contains("spy")) {
                if (property.charAt(0) == '-') {
                    isDesired = isDesired && !isSpy();
                } else {
                    isDesired = isDesired && isSpy();
                }
            } else if (property.contains("sunny")) {
                if (property.charAt(0) == '-') {
                    isDesired = isDesired && !isSunny();
                } else {
                    isDesired = isDesired && isSunny();
                }
            } else if (property.contains("square")) {
                if (property.charAt(0) == '-') {
                    isDesired = isDesired && !isSquare();
                } else {
                    isDesired = isDesired && isSquare();
                }
            } else if (property.contains("jumping")) {
                if (property.charAt(0) == '-') {
                    isDesired = isDesired && !isJumping();
                } else {
                    isDesired = isDesired && isJumping();
                }
            } else if (property.contains("happy")) {
                if (property.charAt(0) == '-') {
                    isDesired = isDesired && !isHappy();
                } else {
                    isDesired = isDesired && isHappy();
                }
            } else if (property.contains("sad")) {
                if (property.charAt(0) == '-') {
                    isDesired = isDesired && !isSad();
                } else {
                    isDesired = isDesired && isSad();
                }
            } else if (property.contains("even")) {
                if (property.charAt(0) == '-') {
                    isDesired = isDesired && !isEven();
                } else {
                    isDesired = isDesired && isEven();
                }
            } else if (property.contains("odd")) {
                if (property.charAt(0) == '-') {
                    isDesired = isDesired && !isOdd();
                } else {
                    isDesired = isDesired && isOdd();
                }
            }
        }
        return isDesired;
    }

    /**
     * Creates 2D array to check all possible mutually exclusive pairs
     * @return      Returns pairs as 2D String Array
     */
    public String[][] getMutuallyExclusivePairs() {
        this.mutuallyExclusivePairs[0] = new String[] {"duck", "spy"};
        this.mutuallyExclusivePairs[1] = new String[] {"sunny", "square"};
        this.mutuallyExclusivePairs[2] = new String[] {"even", "odd"};
        this.mutuallyExclusivePairs[3] = new String[] {"happy", "sad"};
        this.mutuallyExclusivePairs[4] = new String[] {"-duck", "-spy"};
        this.mutuallyExclusivePairs[5] = new String[] {"-even", "-odd"};
        this.mutuallyExclusivePairs[6] = new String[] {"-happy", "-sad"};

        for (int i = 7; i < this.getAvailableProperties().length + 7; i++) {
            this.mutuallyExclusivePairs[i] = new String[] {"-" + this.getAvailableProperties()[i - 7],
                    this.getAvailableProperties()[i - 7]};
        }

        return this.mutuallyExclusivePairs;
    }

    /**
     * Prepares the explanation text for the result
     * @return      String literal representation of the class variable stringBuilder
     */
    public String getPropertiesForOne() {
        // Clear the stringBuilder for new queries
        this.stringBuilder.setLength(0);

        this.stringBuilder.append("Properties of %,d".formatted(this.number)).append("\n");
        this.stringBuilder.append("\t\teven: ").append(isEven()).append("\n");
        this.stringBuilder.append("\t\todd: ").append(isOdd()).append("\n");
        this.stringBuilder.append("\t\tbuzz: ").append(isBuzz()).append("\n");
        this.stringBuilder.append("\t\tduck: ").append(isDuck()).append("\n");
        this.stringBuilder.append("\t\tpalindromic: ").append(isPalindromic()).append("\n");
        this.stringBuilder.append("\t\tgapful: ").append(isGapFul()).append("\n");
        this.stringBuilder.append("\t\tspy: ").append(isSpy()).append("\n");
        this.stringBuilder.append("\t\tsunny: ").append(isSunny()).append("\n");
        this.stringBuilder.append("\t\tsquare: ").append(isSquare()).append("\n");
        this.stringBuilder.append("\t\tjumping: ").append(isJumping()).append("\n");
        this.stringBuilder.append("\t\thappy: ").append(isHappy()).append("\n");
        this.stringBuilder.append("\t\tsad: ").append(isSad()).append("\n");

        return this.stringBuilder.toString();
    }

    /**
     * Prepares explanation texts for the list if user types more than one variable
     * @return      String literal representations of the class variable stringBuilder
     */
    public String getPropertiesForList() {
        // Clear the stringBuilder for new queries
        this.stringBuilder.setLength(0);

        this.stringBuilder.append("\t\t").append("%,d".formatted(this.number))
                          .append(" is ").append(isBuzz() ? "buzz, " : "")
                          .append(isDuck() ? "duck, " : "").append(isPalindromic() ? "palindromic, " : "")
                          .append(isGapFul() ? "gapful, " : "").append(isSpy() ? "spy, " : "")
                          .append(isSunny() ? "sunny, " : "").append(isSquare() ? "square, " : "")
                          .append(isJumping() ? "jumping, " : "").append(isHappy() ? "happy, ": "")
                          .append(isSad() ? "sad, " : "")
                          .append(isOdd() ? "odd" : "").append(isEven() ? "even" : "");

        return this.stringBuilder.toString();
    }
}
