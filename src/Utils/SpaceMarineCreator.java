package Utils;

import BaseObjects.*;
import Utils.MyReaders.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class SpaceMarineCreator {
    static String name;
    static Float x;
    static double y;
    static float health;
    static AstartesCategory astartesCategory;
    static Weapon weapon;
    static MeleeWeapon meleeWeapon;
    static String chapterName;
    static String parentLegion;
    public static SpaceMarine createSpaceMarine() {
        String name = MyStringReader.read("������� ��� ������� ", false);
        Float x = MyFloatReader.read("������� ���������� x (float) ");
        double y = MyPrimDoubleReader.read("������� ���������� y (double) ");
        float health = MyPrimFloatReader.read("������� �������� ������� (float) ", ">0");
        AstartesCategory astartesCategory = MyAstartesCategoryReader.read("������� ��������� �������.", false);
        Weapon weapon = MyWeaponReader.read("������� ��� ������ ", true);
        MeleeWeapon meleeWeapon = MyMeleeWeaponReader.read("������� ��� ������ �������� ��� ", false);
        String chapterName = MyStringReader.read("������� �������� ����� ", false);
        String parentLegion = MyStringReader.read("������� �������� parentLegion ", true);

        return new SpaceMarine(name, new Coordinates(x, y), health, astartesCategory, weapon, meleeWeapon, new Chapter(chapterName, parentLegion));
    }

    public static SpaceMarine createScriptSpaceMarine(ArrayList<String> parameters) {
        if (validateArray(parameters)) {
            AstartesCategory astartesCategory = null;
            Weapon weapon = null;
            Chapter chapter = new Chapter(null, null);
            if (!parameters.get(4).isEmpty()) { astartesCategory = AstartesCategory.valueOf(parameters.get(4)); }
            if (!parameters.get(5).isEmpty()) { weapon = Weapon.valueOf(parameters.get(5)); }
            if (!parameters.get(7).isEmpty()) { chapter.setName(String.valueOf(parameters.get(7))); }
            if (!parameters.get(8).isEmpty()) { chapter.setParentLegion(String.valueOf(parameters.get(8))); }
            return new SpaceMarine(parameters.get(0),
                    new Coordinates(Float.parseFloat(parameters.get(1)), Double.parseDouble(parameters.get(2))),
                    Float.parseFloat(parameters.get(3)),
                    astartesCategory,
                    weapon,
                    MeleeWeapon.valueOf(parameters.get(6)),
                    chapter);
        } else { System.out.println("���� �� ���������� �� ������������� �����������."); }

        return null;
    }
    private static boolean validateArray(ArrayList<String> parameters) {
        try {
            return !parameters.get(0).isEmpty()
                    && Float.parseFloat(parameters.get(1)) < Float.MAX_VALUE
                    && Double.parseDouble(parameters.get(2)) < Double.MAX_VALUE
                    && Float.parseFloat(parameters.get(3)) > 0
                    && (MyAstartesCategoryReader.checkExist(parameters.get(4)) || parameters.get(4).isEmpty())
                    && (MyWeaponReader.checkExist(parameters.get(5)) || parameters.get(5).isEmpty())
                    && !parameters.get(6).isEmpty();

        } catch (NumberFormatException ex) { return false; }
    }
}
