package machine;

import java.util.Scanner;

/**
 * UserInterface Class
 */
public class UserInterface {

    private final CoffeeMaker coffeeMaker;
    private final Scanner scanner;

    /**
     * Constructor
     * @param coffeeMaker       CoffeeMaker object
     * @param scanner           Scanner object
     */
    public UserInterface(CoffeeMaker coffeeMaker, Scanner scanner) {
        this.coffeeMaker = coffeeMaker;
        this.scanner = scanner;
    }

    /**
     * Starts the UI
     */
    public void start() {

        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            System.out.print("> ");
            String userAction = this.scanner.nextLine().toLowerCase();
            if (!handleUserAction(userAction)) {
                break;
            }
        }
    }

    /**
     * Handles the user action
     * @param userAction        User action read from the scanner as String literal
     * @return                  Returns true if action is processed, false if user wants to exit
     */
    public boolean handleUserAction(String userAction) {
        switch (userAction) {
            case "buy":
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");
                System.out.print("> ");
                String userChoice = this.scanner.nextLine();
                if ("back".equals(userChoice)) {
                    return true;
                } else if (this.coffeeMaker.buy(Integer.parseInt(userChoice))) {
                    System.out.println("I have enough resources, making you a coffee");
                    return true;
                }
                System.out.println(this.coffeeMaker.findMissingIngredient());
                break;
            case "fill":
                System.out.println("\nWrite how many ml of water you want to add:");
                System.out.print("> ");
                int addWater = Integer.parseInt(this.scanner.nextLine());
                System.out.println("Write how many ml of milk you want to add:");
                System.out.print("> ");
                int addMilk = Integer.parseInt(this.scanner.nextLine());
                System.out.println("Write how many grams of coffee beans you want to add:");
                System.out.print("> ");
                int addCoffeeBeans = Integer.parseInt(this.scanner.nextLine());
                System.out.println("Write how many disposable cups you want to add:");
                System.out.print("> ");
                int addCups = Integer.parseInt(this.scanner.nextLine());
                this.coffeeMaker.fill(addWater, addMilk, addCoffeeBeans, addCups);
                break;
            case "take":
                System.out.println("\nI gave you $" + this.coffeeMaker.getMoney());
                this.coffeeMaker.setMoney(0);
                break;
            case "remaining":
                System.out.println();
                System.out.println(this.coffeeMaker.getCurrentState());
                break;
            case "exit":
                return false;
        }
        return true;
    }
}
