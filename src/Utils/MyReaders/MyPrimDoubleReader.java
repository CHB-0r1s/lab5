package Utils.MyReaders;

import java.util.Scanner;

public class MyPrimDoubleReader {
    public static double read(String consoleMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(consoleMessage);
        double result = 0;
        while (true) {
            try {
                result = Double.parseDouble(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException ex) {
                System.out.print("Вы должны ввести число (double), попробуйте снова: ");
            }
        }
        return result;
    }
}
