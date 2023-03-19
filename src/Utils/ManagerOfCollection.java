package Utils;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import BaseObjects.*;

import javax.xml.stream.*;

public class ManagerOfCollection {
    private static TreeSet<SpaceMarine> myCollection;
    private static ZonedDateTime dateOfCreate;

    public static void createMyCollection() {
        if (myCollection == null) {
            myCollection = new TreeSet<>();
            dateOfCreate = ZonedDateTime.now();
        }
    }

    public static void getInformationAbout() {
        System.out.println("Информация о коллекции: ");
        System.out.println("Тип коллекции - " + myCollection.getClass().getName());
        System.out.println("Дата создания коллекции - " + dateOfCreate);
        System.out.println("Количество элементов - " + myCollection.size());
        System.out.println("_________________________________________________________\n");
    }

    public static void add(SpaceMarine spaceMarine) {
        myCollection.add(spaceMarine);
    }

    public static TreeSet<SpaceMarine> getMyCollection() {
        return myCollection;
    }

    public static void show() {
        for (SpaceMarine spaceMarine: myCollection) {
            System.out.println("ID объекта - " + spaceMarine.getId());
            System.out.println("Имя объекта - " + spaceMarine.getName());
            System.out.println("Координата X объекта - " + spaceMarine.getCoordinates().getX());
            System.out.println("Координата Y объекта - " + spaceMarine.getCoordinates().getY());
            System.out.println("Дата и время создания объекта - " + spaceMarine.getCreationDate());
            System.out.println("Здоровье объекта- " + spaceMarine.getHealth());
            System.out.println("Категория объекта- " + spaceMarine.getCategory());
            System.out.println("Оружие объекта- " + spaceMarine.getWeaponType());
            System.out.println("Оружие ближнего боя объекта - " + spaceMarine.getMeleeWeapon());
            System.out.println("Расположение объекта- " + spaceMarine.getChapter().getName() + ":" + spaceMarine.getChapter().getParentLegion());
            System.out.println("_________________________________________________________\n");
        }
    }

    public static void update(SpaceMarine marineToUpdate, long elementId) {
        myCollection.forEach(spaceMarine -> {
            if (spaceMarine.getId() == elementId) {
                spaceMarine.setName(marineToUpdate.getName());
                spaceMarine.setCoordinates(marineToUpdate.getCoordinates());
                spaceMarine.setHealth(marineToUpdate.getHealth());
                spaceMarine.setCategory(marineToUpdate.getCategory());
                spaceMarine.setWeaponType(marineToUpdate.getWeaponType());
                spaceMarine.setMeleeWeapon(marineToUpdate.getMeleeWeapon());
                spaceMarine.setChapter(marineToUpdate.getChapter());
            }
        });
    }

    public static boolean elemExist(long ID) {
        for (SpaceMarine spaceMarine : ManagerOfCollection.getMyCollection()) {
            if (spaceMarine.getId() == ID) {
                return spaceMarine.getId() == ID;
            }
        }
        return false;
    }

    public static void remove_by_id(long ID) {
        myCollection.forEach(
                spaceMarine -> {
                    if (spaceMarine.getId() == ID) {
                        myCollection.remove(spaceMarine);
                    }
                }
        );
    }

    public static void clear() {
        myCollection.clear();
    }

    public static void remove_greater(SpaceMarine spaceMarine) {
        AtomicInteger x = new AtomicInteger();

        myCollection.forEach(
                spaceMarine1 -> {
                    if (spaceMarine1.compareTo(spaceMarine) > 0) {
                        myCollection.remove(spaceMarine1);
                        x.getAndIncrement();
                    }
                }
        );
        System.out.println("Найдено и удалено " + x + " элементов.");
    }

    public static void remove_lower(SpaceMarine spaceMarine) {
        AtomicInteger x = new AtomicInteger();

        myCollection.forEach(
                spaceMarine1 -> {
                    if (spaceMarine1.compareTo(spaceMarine) < 0) {
                        myCollection.remove(spaceMarine1);
                        x.getAndIncrement();
                    }
                }
        );
        System.out.println("Найдено и удалено " + x + " элементов.");
    }

    public static void save() throws IOException {
        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new BufferedOutputStream(new FileOutputStream("result.xml")));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("MyCollection");
            myCollection.forEach(spaceMarine -> {
                try {
                    writer.writeStartElement("SpaceMarine");

                        writer.writeStartElement("id");
                        writer.writeCharacters(Long.toString(spaceMarine.getId()));
                        writer.writeEndElement();

                        writer.writeStartElement("name");
                        writer.writeCharacters(spaceMarine.getName().replaceAll("<", "&lt;").
                                replaceAll(">", "&gt;"));
                        writer.writeEndElement();

                        writer.writeStartElement("coordinates");

                            writer.writeStartElement("x");
                            writer.writeCharacters(Float.toString(spaceMarine.getCoordinates().getX()));
                            writer.writeEndElement();

                            writer.writeStartElement("y");
                            writer.writeCharacters(String.valueOf(spaceMarine.getCoordinates().getY()));
                            writer.writeEndElement();

                        writer.writeEndElement();

                        writer.writeStartElement("creationDate");
                        writer.writeCharacters(spaceMarine.getCreationDate().toString());
                        writer.writeEndElement();

                        writer.writeStartElement("health");
                        writer.writeCharacters(String.valueOf(spaceMarine.getHealth()));
                        writer.writeEndElement();

                        writer.writeStartElement("category");
                        writer.writeCharacters(spaceMarine.getCategory().toString());
                        writer.writeEndElement();

                        writer.writeStartElement("weaponType");
                        writer.writeCharacters(spaceMarine.getWeaponType().toString());
                        writer.writeEndElement();

                        writer.writeStartElement("meleeWeapon");
                        writer.writeCharacters(spaceMarine.getMeleeWeapon().toString());
                        writer.writeEndElement();

                        writer.writeStartElement("chapter");

                            writer.writeStartElement("name");
                            writer.writeCharacters(spaceMarine.getChapter().getName());
                            writer.writeEndElement();

                            writer.writeStartElement("parentLegion");
                            writer.writeCharacters(spaceMarine.getChapter().getParentLegion());
                            writer.writeEndElement();

                        writer.writeEndElement();

                    writer.writeEndElement();
                } catch (XMLStreamException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
        } catch (XMLStreamException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void remove_all_by_health(double HP) {
        AtomicInteger x = new AtomicInteger();
        myCollection.forEach(
                spaceMarine -> {
                    if (spaceMarine.getHealth() == HP) {
                        myCollection.remove(spaceMarine);
                        x.getAndIncrement();
                    }
                }
        );
        System.out.println("Найдено и удалено " + x + " элементов.");
    }

    public static void max_by_melee_weapon() {
        MeleeWeapon[] list = MeleeWeapon.values();
        int maxLength = 0;
        MeleeWeapon maxMeleeWeapon = null;

        for (MeleeWeapon w: list) {
            if (maxLength < w.toString().length()) {
                maxLength = w.toString().length();
                maxMeleeWeapon = w;
            };
        }
        MeleeWeapon finalMaxMeleeWeapon = maxMeleeWeapon;
        System.out.println(finalMaxMeleeWeapon);
        for (SpaceMarine spaceMarine: myCollection) {
            assert finalMaxMeleeWeapon != null;
            if (Objects.equals(spaceMarine.getMeleeWeapon().toString(), finalMaxMeleeWeapon.toString())) {
                System.out.println("ID объекта - " + spaceMarine.getId());
                System.out.println("Имя объекта - " + spaceMarine.getName());
                System.out.println("Координата X объекта - " + spaceMarine.getCoordinates().getX());
                System.out.println("Координата Y объекта - " + spaceMarine.getCoordinates().getY());
                System.out.println("Дата и время создания объекта - " + spaceMarine.getCreationDate());
                System.out.println("Здоровье объекта- " + spaceMarine.getHealth());
                System.out.println("Категория объекта- " + spaceMarine.getCategory());
                System.out.println("Оружие объекта- " + spaceMarine.getWeaponType());
                System.out.println("Оружие ближнего боя объекта - " + spaceMarine.getMeleeWeapon());
                System.out.println("Расположение объекта- " + spaceMarine.getChapter().getName() + ":" + spaceMarine.getChapter().getParentLegion());
                System.out.println("_________________________________________________________\n");
                break;
            }
        }
    }

    public static void print_unique_chapter() {
        TreeSet<Chapter> setOfChapter = new TreeSet<>();
        for (SpaceMarine spaceMarine: myCollection) {
            setOfChapter.add(spaceMarine.getChapter());
        }

        for (Chapter chapter: setOfChapter) {
            System.out.println("name уникального chapter: " + chapter.getName());
            System.out.println("parentLegion уникального chapter: " + chapter.getParentLegion());

        }
    }

    public static void fillFromXml(String path) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            factory.setProperty("javax.xml.stream.isCoalescing", true);
            XMLStreamReader xmlr = factory.createXMLStreamReader(path, new BufferedInputStream(new FileInputStream(path)));
            int elemCounter = 0;
            Long id = null;
            String name = null;
            Float x = null;
            double y = 0;
            float health = 0;
            ZonedDateTime creationDate = null;
            AstartesCategory category = null;
            Weapon weaponType = null;
            MeleeWeapon meleeWeapon = null;
            String chapter_name = null;
            String parentLegion = null;
            while (xmlr.hasNext()) {
                xmlr.next();


                if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
                    try {
                    switch (elemCounter) {
                            case 0 -> id = Long.parseLong(xmlr.getText());
                            case 1 -> name = xmlr.getText();
                            case 2 -> x = (Float) Float.parseFloat(xmlr.getText());
                            case 3 -> y = Double.parseDouble(xmlr.getText());
                            case 4 -> creationDate = ZonedDateTime.parse(xmlr.getText());
                            case 5 -> health = Float.parseFloat(xmlr.getText());
                            case 6 -> category = AstartesCategory.valueOf(xmlr.getText());
                            case 7 -> weaponType = Weapon.valueOf(xmlr.getText());
                            case 8 -> meleeWeapon = MeleeWeapon.valueOf(xmlr.getText());
                            case 9 -> chapter_name = xmlr.getText();
                            case 10 -> parentLegion = xmlr.getText();
                        }
                    }
                    catch (Exception exception) {
                        //exception.printStackTrace();
                        System.out.println("Невалидные данные в указанном файле");
                    }
                    if (elemCounter == 10) {

                        SpaceMarine spaceMarine = new SpaceMarine(id, name, new Coordinates(x, y),
                                creationDate, health, category, weaponType, meleeWeapon,
                                new Chapter(chapter_name, parentLegion));
                        if (spaceMarine.validateID() &&
                            spaceMarine.validateName() &&
                            spaceMarine.validateCoordinates() &&
                            spaceMarine.validateCreationDate() &&
                            spaceMarine.validateHealth() &&
                            spaceMarine.validateCategory() &&
                            spaceMarine.validateMeleeWeapon()) {

                            myCollection.add(spaceMarine);
                        }
                    }
                    elemCounter = (elemCounter + 1) % 11;

                }

            }
        } catch (FileNotFoundException | XMLStreamException ex) {
            ex.printStackTrace();
        }
    }
}