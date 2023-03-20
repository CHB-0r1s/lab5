package Utils.MyReaders;

import java.util.Scanner;

public class MyFloatReader {
    public static Float read(String consoleMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(consoleMessage);
        Float result = 0.0F;
        while (true) {
            try {
                result = Float.parseFloat(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException ex) {
                System.out.print("You have to enter a number (float), try again: ");
            }
        }
        return result;
    }
}
