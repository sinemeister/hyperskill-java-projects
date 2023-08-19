package chucknorris;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        startUserInterface(scanner);
    }

    /**
     * Asks the user what they want to do, and calls the related methods
     * @param scanner   Standard scanner to read user inputs
     */
    public static void startUserInterface(Scanner scanner) {
        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            String userInput = scanner.nextLine();

            if (userInput.equals("exit")) {
                System.out.println("Bye!");
                break;
            } else if (userInput.equals("encode")) {
                System.out.println("Input string:");
                String inputString = scanner.nextLine();
                System.out.println("Encoded string:\n" + chuckNorrisUnaryEncrypt(getBinaryCode(inputString)));
            } else if (userInput.equals("decode")) {
                System.out.println("Input encoded string:");
                String inputString = scanner.nextLine();
                String result = chuckNorrisUnaryDecrypt(inputString);
                if (result.contains("valid")) {
                    System.out.println(chuckNorrisUnaryDecrypt(inputString));
                    System.out.println();
                    continue;
                }
                System.out.println("Decoded string:\n" + getText(chuckNorrisUnaryDecrypt(inputString)));
            } else {
                System.out.println("There is no '" + userInput + "' operation");
            }
            System.out.println();
        }
    }

    /**
     * Converts the given literal input to the binary representation
     * Fixes the binary code to the 7-bit
     * @param inputString   The String literal to be converted to the binary
     * @return              The binary representation of the parameter as String
     */
    public static String getBinaryCode(String inputString) {
        String binaryCode = "";
        for (int i = 0; i < inputString.length(); i++) {
            String charBinaryCode = Integer.toBinaryString(inputString.charAt(i));
            while (charBinaryCode.length() < 7) {
                charBinaryCode = "0" + charBinaryCode;
            }
            binaryCode += charBinaryCode;
        }
        return binaryCode;
    }

    /**
     * Converts the given literal input of 7-bit binary code back to the literal String representation
     * @param inputString   The String literal of 7-bit binary code to be converted to the character
     * @return              The ASCII representation of the parameter as String
     */
    public static String getText(String inputString) {
        StringBuilder literalText = new StringBuilder();

        for (int i = 0; i < inputString.length(); i += 7) {
            Character c = (char) Integer.parseInt(inputString.substring(i, i + 7), 2);
            literalText.append(c);
        }
        return literalText.toString();
    }

    /**
     * Encrypts the given binary code as Chuck Norris Unary (CNU) Code
     * @param inputBinaryCode   The String literal of the binary code to be encrypted as CNU
     * @return                  The CNU encryption of the parameter as String
     */
    public static String chuckNorrisUnaryEncrypt(String inputBinaryCode) {
        StringBuilder result = new StringBuilder();
        if (inputBinaryCode.charAt(0) == '0') {
            result.append("00 0");
        } else {
            result.append("0 0");
        }

        for (int i = 1; i < inputBinaryCode.length(); i++) {
            if (inputBinaryCode.charAt(i) == inputBinaryCode.charAt(i - 1)) {
                result.append("0");
            } else {
                if (inputBinaryCode.charAt(i) == '0') {
                    result.append(" 00 0");
                } else {
                    result.append(" 0 0");
                }
            }
        }
        return result.toString();
    }

    /**
     * Converts the literal Chuck Norris Unary (CNU) code back to the literal 7-bit binary code
     * @param inputCNUCode  The String literal of CNU code to be converted back to 7-bit binary
     * @return              The 7-bit binary code blocks as String
     */
    public static String chuckNorrisUnaryDecrypt(String inputCNUCode) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputCNUCode.length(); i++) {
            if (inputCNUCode.charAt(i) != '0' && inputCNUCode.charAt(i) != ' ') {
                return "Encoded string is not valid.";
            }
        }

        String[] pieces = inputCNUCode.split(" ");

        if (pieces.length % 2 != 0) {
            return "Encoded string is not valid.";
        }

        for (int i = 0; i < pieces.length; i += 2) {
            if (pieces[i].equals("0")) {
                for (int j = 0; j < pieces[i + 1].length(); j++) {
                    result.append("1");
                }
            } else if (pieces[i].equals("00")) {
                for (int j = 0; j < pieces[i + 1].length(); j++) {
                    result.append("0");
                }
            } else {
                return "Encoded string is not valid.";
            }
        }

        if (result.toString().length() % 7 != 0) {
            return "Encoded string is not valid.";
        }

        return result.toString();
    }
}