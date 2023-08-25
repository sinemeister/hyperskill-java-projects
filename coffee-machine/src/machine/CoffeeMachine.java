package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        // Instantiate needed objects to pass in UserInterface class object constructor
        Scanner scanner = new Scanner(System.in);
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        // Instantiate and start UI
        UserInterface ui = new UserInterface(coffeeMaker, scanner);
        ui.start();
    }
}
