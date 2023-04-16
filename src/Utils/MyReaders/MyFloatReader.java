package Utils.MyReaders;

import java.util.Scanner;

public class MyFloatReader {
    public static float read(String consoleMessage, String valueParam) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(consoleMessage);
        float result = 0.0F;
        while (true) {
            try {
                result = Float.parseFloat(scanner.nextLine().trim());
                // TODO: ��������� ��� � ������� ������� ��� ������� ��������
                switch (valueParam) {
                    case (">0"):
                        if (result <= 0) {
                            System.out.println("�� ����� �� ���������� ��������. " + "��� ������ ���� " + valueParam + ". ���������� �����: ");
                            continue;
                        }
                        else {
                            break;
                        }
                    case ("<0"):
                        if (result >= 0) {
                            System.out.println("�� ����� �� ���������� ��������. " + "��� ������ ���� " + valueParam + ". ���������� �����: ");
                            continue;
                        }
                        else {
                            break;
                        }
                    case (">=0"):
                        if (result < 0) {
                            System.out.println("�� ����� �� ���������� ��������. " + "��� ������ ���� " + valueParam + ". ���������� �����: ");
                            continue;
                        }
                        else {
                            break;
                        }
                    case ("<=0"):
                        if (result < 0) {
                            System.out.println("�� ����� �� ���������� ��������. " + "��� ������ ���� " + valueParam + ". ���������� �����: ");
                            continue;
                        }
                        else {
                            break;
                        }
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.print("�� ������ ������ ����� (float), ���������� �����: ");
            }
        }
        return result;
    }

    public static float read(String consoleMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(consoleMessage);
        float result;
        while (true) {
            try {
                result = Long.parseLong(scanner.nextLine().trim());
                break;
            } catch (NumberFormatException ex) {
                System.out.print("You have to enter a number (long), try again: ");
            }
        }
        return result;
    }
}