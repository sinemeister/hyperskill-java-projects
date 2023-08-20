package bullscows;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Instantiation of the necessary objects to be passed in UserInterface constructor
        Scanner scanner = new Scanner(System.in);
        CodeGenerator codeGenerator = new CodeGenerator();
        Grader grader = new Grader();

        // UserInterface object instantiation and start() method call
        UserInterface ui = new UserInterface(grader, codeGenerator, scanner);
        ui.start();
    }
}
