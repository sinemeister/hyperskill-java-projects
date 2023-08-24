package rockpaperscissors;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Instantiate the necessary objects to be passed into UI constructor
        Scanner scanner = new Scanner(System.in);
        GameManager gameManager = new GameManager();

        // Instantiate UI and start
        UserInterface ui = new UserInterface(scanner, gameManager);
        ui.start();
    }
}
