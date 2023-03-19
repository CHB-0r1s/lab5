package Utils.MyReaders;

import BaseObjects.AstartesCategory;
import BaseObjects.MeleeWeapon;

import java.util.Arrays;
import java.util.Scanner;

public class MyMeleeWeaponReader {
    public static boolean checkExist(String toContains) {
        return Arrays.stream(MeleeWeapon.values()).anyMatch((meleeWeapon) -> meleeWeapon.name().equals(toContains));
    }
    public static MeleeWeapon read(String consoleMessage, boolean nullable) {
        Scanner scanner = new Scanner(System.in);  // TODO: �������� ��������� � ����

        System.out.print(consoleMessage + " �������� ������ �������� ��� �� ��������������("
                + Arrays.asList(MeleeWeapon.values()) + "): ");
        String inputString = "";
        while(!nullable && inputString.equals("")) {
            inputString = scanner.nextLine().trim();
            if (inputString.equals("")) {System.out.print("������ ���� �� ����� ���� ������. " + consoleMessage);}
            try {
                Enum.valueOf(MeleeWeapon.class, inputString);
            }
            catch (Exception ex) {
                System.out.println("�������� ��� ��������� �������");
                inputString = "";
            }
        }
        return Enum.valueOf(MeleeWeapon.class, inputString);
    }
}

