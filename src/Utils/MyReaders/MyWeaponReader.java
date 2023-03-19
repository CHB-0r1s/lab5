package Utils.MyReaders;

import BaseObjects.AstartesCategory;
import BaseObjects.Weapon;

import java.util.Arrays;
import java.util.Scanner;

public class MyWeaponReader {
    public static boolean checkExist(String toContains) {
        return Arrays.stream(Weapon.values()).anyMatch((weapon) -> weapon.name().equals(toContains));
    }
    public static Weapon read(String consoleMessage, boolean nullable) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(consoleMessage + " �������� ��������� �� ��������������("
                + Arrays.asList(Weapon.values()) + "): ");
        String inputString = "";
        while(inputString.equals("")) {
            inputString = scanner.nextLine().trim();
            if (inputString.equals("") && !nullable) {System.out.print("������ ���� �� ����� ���� ������. " + consoleMessage);}
            else {
                if (inputString.equals("")) {return Weapon.NULL;}
                try {
                    Enum.valueOf(Weapon.class, inputString);
                }
                catch (Exception ex) {
                    System.out.println("�������� ��� ��������� �������");
                    inputString = "";
                }
            }
        }
        return Enum.valueOf(Weapon.class, inputString);
    }
}

