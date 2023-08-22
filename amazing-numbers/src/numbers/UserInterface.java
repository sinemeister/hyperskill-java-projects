package numbers;

import java.util.*;

/**
 * UserInterface Class
 */
public class UserInterface {

    private final Scanner scanner;
    private final Number numberObj;

    /**
     * Constructor
     * Sets class variables
     * @param scanner       Scanner object to be used
     * @param numberObj     Number object to be used
     */
    public UserInterface(Scanner scanner, Number numberObj) {
        this.scanner = scanner;
        this.numberObj = numberObj;
    }

    /**
     * Starts the UI
     */
    public void start() {

        // Welcome user
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests:\n- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("\t* the first parameter represents a starting number;");
        System.out.println("\t* the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.\n");

        // Request loop
        while (true) {
            System.out.print("Enter a request: > ");

            // Create four variables beforehand
            long firstParameter;
            long secondParameter;

            // Read input as String
            String userInputAsString = this.scanner.nextLine();

            // Split the user input and handle it
            String[] pieces = userInputAsString.split(" ");
            if (pieces.length == 1) {
                try {
                    firstParameter = Long.parseLong(pieces[0]);
                } catch (NumberFormatException e) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }
                secondParameter = 0;
            } else if (pieces.length == 2) {
                try {
                    firstParameter = Long.parseLong(pieces[0]);
                } catch (NumberFormatException e) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }
                try {
                    secondParameter = Long.parseLong(pieces[1]);
                } catch (NumberFormatException e) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }
            } else if (pieces.length == 3) {
                try {
                    firstParameter = Long.parseLong(pieces[0]);
                } catch (NumberFormatException e) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }
                try {
                    secondParameter = Long.parseLong(pieces[1]);
                } catch (NumberFormatException e) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }

                if (!Arrays.asList(this.numberObj.getAvailableProperties()).contains(pieces[2].toLowerCase()) &&
                !Arrays.asList(this.numberObj.getNegAvailableProperties()).contains(pieces[2].toLowerCase())) {
                    System.out.printf("The property [%s] is wrong.\nAvailable properties: %s",
                            pieces[2].toLowerCase(), Arrays.toString(this.numberObj.getAvailableProperties()));
                    System.out.println();
                    continue;
                }
            } else if (pieces.length > 3) {
                try {
                    firstParameter = Long.parseLong(pieces[0]);
                } catch (NumberFormatException e) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }
                try {
                    secondParameter = Long.parseLong(pieces[1]);
                } catch (NumberFormatException e) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }
                String[] properties = new String[pieces.length - 2];
                System.arraycopy(pieces, 2, properties, 0, pieces.length - 2);

                if (!isValidProperty(properties)) {
                    System.out.println(findInvalidProperties(properties));
                    continue;
                } else if (isMutuallyExclusive(properties)) {
                    System.out.println("There are no numbers with these properties.\n");
                    continue;
                }
            } else {
                System.out.println("Provide maximum twelve parameters.");
                continue;
            }

            if (firstParameter == 0) {
                System.out.println("Goodbye!");
                break;
            } else if (firstParameter < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
                continue;
            } else if (secondParameter < 0) {
                System.out.println("The second parameter should be a natural number.");
                continue;
            }

            /* If user input contains only one parameter, get properties of the number
               Else get list of the properties
             */
            if (pieces.length == 1) {
                this.numberObj.setNumber(firstParameter);
                System.out.println(this.numberObj.getPropertiesForOne());
            } else if (pieces.length == 2) {
                for (int i = 0; i < secondParameter; i++) {
                    this.numberObj.setNumber(firstParameter++);
                    System.out.println(this.numberObj.getPropertiesForList());
                }
                System.out.println();
            } else {
                String[] newArray = new String[pieces.length - 2];
                for (int i = 2; i < pieces.length; i++) {
                    newArray[i - 2] = pieces[i].toLowerCase();
                }
                int count = 0;
                while (count < secondParameter) {
                    this.numberObj.setNumber(firstParameter++);
                    if (this.numberObj.isDesiredProperty(newArray)) {
                        System.out.println(this.numberObj.getPropertiesForList());
                        count++;
                    }
                }
            }
        }
    }

    /**
     * Finds if there are mutually exclusive properties in user input
     * @param properties        String[] array of user input properties
     * @return                  Returns result as Boolean
     */
    public boolean isMutuallyExclusive(String[] properties) {
        Set<String> propertySet = new HashSet<>(Arrays.asList(properties));
        String[][] mutuallyExclusivePairs = this.numberObj.getMutuallyExclusivePairs();

        for (String[] pair : mutuallyExclusivePairs) {
            if (propertySet.contains(pair[0]) && propertySet.contains(pair[1])) {
                System.out.printf("The request contains mutually exclusive properties [%s, %s]\n",
                        pair[0], pair[1]);
                return true;
            }
        }
        return false;
    }


    /**
     * Checks if user provided valid properties as input
     * @param properties        String[] array of user input properties
     * @return                  Returns result as Boolean
     */
    public boolean isValidProperty(String[] properties) {
        boolean isValid = true;
        for (String property : properties) {
            isValid = isValid && ((Arrays.asList(this.numberObj.getAvailableProperties()).contains(property
                    .toLowerCase()) || (Arrays.asList(this.numberObj.getNegAvailableProperties()).contains(property
                    .toLowerCase()))));
        }
        return isValid;
    }

    /**
     * If one or more than one of the properties from user input not valid, finds them
     * @param properties        String[] array of the user input properties
     * @return                  Returns String literal of the error message to be printed
     */
    public String findInvalidProperties(String[] properties) {
        StringBuilder errorBuilder = new StringBuilder("[");
        int count = 0;

        for (int i = 0; i < properties.length; i++) {
            if (!Arrays.asList(this.numberObj.getAvailableProperties()).contains(properties[i].toLowerCase())
            && !Arrays.asList(this.numberObj.getNegAvailableProperties()).contains(properties[i].toLowerCase())) {
                if (i != properties.length - 1) {
                    errorBuilder.append(properties[i]).append(", ");
                    count++;
                } else if (count == 0 && i == properties.length - 1) {
                    errorBuilder.append(properties[i]).append("]");
                    count++;
                } else if (i == properties.length - 1) {
                    errorBuilder.append(properties[i]).append("]");
                    count++;
                }
            }
        }
        if (count == 1) {
            return "The property " + errorBuilder + " is wrong.\nAvailable properties: "
                    + Arrays.asList(this.numberObj.getAvailableProperties());
        }
        return "The properties " + errorBuilder + " are wrong.\nAvailable properties: "
                   + Arrays.asList(this.numberObj.getAvailableProperties());
    }
}
