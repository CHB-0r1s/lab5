package Utils.MyReaders;

import BaseObjects.AstartesCategory;
import jdk.jshell.EvalException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyAstartesCategoryReader {
    public static boolean checkExist(String toContains) {
        return Arrays.stream(AstartesCategory.values()).anyMatch((astartesCategory) -> astartesCategory.name().equals(toContains));
    }
    public static AstartesCategory read(String consoleMessage, boolean nullable) {
        Scanner scanner = new Scanner(System.in);  // TODO: Проверка вхождения в енум

        System.out.print(consoleMessage + " Выберите категорию из представленных("
                + Arrays.asList(AstartesCategory.values()) + "): ");
        String inputString = "";
        while(!nullable && inputString.equals("")) {
            inputString = scanner.nextLine().trim();
            if (inputString.equals("")) {System.out.print("Данное поле не может быть пустым. " + consoleMessage);}
            try {
                Enum.valueOf(AstartesCategory.class, inputString);
            }
            catch (Exception ex) {
                System.out.println("Неверное имя категории объекта");
                inputString = "";
            }
        }
        return Enum.valueOf(AstartesCategory.class, inputString);
    }
}



