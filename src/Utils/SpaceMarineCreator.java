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
        String name = MyStringReader.read("¬ведите им€ объекта ", false);
        Float x = MyFloatReader.read("¬ведите координату x (float) ");
        double y = MyPrimDoubleReader.read("¬ведите координату y (double) ");
        float health = MyPrimFloatReader.read("¬ведите здоровье объекта (float) ", ">0");
        AstartesCategory astartesCategory = MyAstartesCategoryReader.read("¬ведите категорию объекта.", false);
        Weapon weapon = MyWeaponReader.read("¬ведите тип оружи€ ", true);
        MeleeWeapon meleeWeapon = MyMeleeWeaponReader.read("¬ведите тип оружи€ ближнего бо€ ", false);
        String chapterName = MyStringReader.read("¬ведите название части ", false);
        String parentLegion = MyStringReader.read("¬ведите название parentLegion ", true);

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
        } else { System.out.println("ќдин из параметров не соответствует требовани€м."); }

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
