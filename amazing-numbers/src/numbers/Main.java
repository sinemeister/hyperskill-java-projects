package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Instantiation of the necessary objects to be passed into UserInterface constructor
        Scanner scanner = new Scanner(System.in);
        Number numberObj = new Number();

        // Instantiate UserInterface class object ui
        UserInterface ui = new UserInterface(scanner, numberObj);
        ui.start();
    }
}
