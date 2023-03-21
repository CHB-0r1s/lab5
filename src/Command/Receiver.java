package Command;

import BaseObjects.*;
import Command.ConcreteCommands.ExecuteScript;
import Utils.ManagerOfCollection;
import Utils.SpaceMarineCreator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Receiver {
    private final Invoker commandInvoker;

    public Receiver(Invoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }

    public void help() {
        commandInvoker.invokerHashMap.forEach((name, command) -> command.writeInfo());
    }

    public void info() {
        ManagerOfCollection.getInformationAbout();
    }

    public void show() {
        ManagerOfCollection.show();
    }

    public void add() {
        SpaceMarine spaceMarine = SpaceMarineCreator.createSpaceMarine();
        System.out.println("An element with ID has been created: " + spaceMarine.getId());
        ManagerOfCollection.add(spaceMarine);
    }

    public void update(String id) {
        long ID;
        try {
            ID = Long.parseLong(id);
            if (ManagerOfCollection.elemExist(ID)) {
                ManagerOfCollection.update(SpaceMarineCreator.createSpaceMarine(), ID);
                System.out.println("Update completed");
            }
            else {System.out.println("The item with this ID is not in the collection.");}
        } catch (NumberFormatException e) {
            System.out.println("The command is not executed. You have entered an incorrect argument.");
        }
    }

    public void remove_by_id(String id) {
        long ID;
        try {
            ID = Long.parseLong(id);
            if (ManagerOfCollection.elemExist(ID)) {
                ManagerOfCollection.remove_by_id(ID);
                System.out.println("������� � ID " + ID + " ������� ������ �� ���������.");
            } else {System.out.println("�������� � ����� ID ��� � ���������.");}
        } catch (NumberFormatException e) {
            System.out.println("������� �� ���������. �� ����� ������������ ��������.");
        }
    }

    public void clear() {
        ManagerOfCollection.clear();
    }

    public void exit() {
        //System.out.println("��������� ���� ��������� ����� �������? [yes/no]");
        // TODO: � ��������� ��� ����������� ������������ ���������� ���������
        System.out.println("��������� ��������� ������, ����-����");
        System.exit(0);
    }

    public void remove_greater() {
        ManagerOfCollection.remove_greater(SpaceMarineCreator.createSpaceMarine());
    }

    public void remove_lower() {
        ManagerOfCollection.remove_lower(SpaceMarineCreator.createSpaceMarine());
    }

    public void save() throws IOException {
        ManagerOfCollection.save();
    }

    public void execute_script(String path) throws IOException {
        String line;
        String command;
        ArrayList<String> parameters = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(path)), StandardCharsets.UTF_8))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(" ")[0].matches("add|update|remove_greater|remove_lower")) {
                    command = line;
                    for (int i = 0; i < 9; i++) {
                        if (line != null) {
                            line = bufferedReader.readLine();
                            parameters.add(line);
                        } else { System.out.println("There are not enough parameters to create an object."); break; }
                    }
                    SpaceMarine spaceMarine = SpaceMarineCreator.createScriptSpaceMarine(parameters);
                    switch (command.split(" ")[0]) {
                        case "add" -> ManagerOfCollection.add(spaceMarine);
                        case "update" -> ManagerOfCollection.update(spaceMarine, Long.parseLong(command.split(" ")[1]));
                        case "remove_greater" -> ManagerOfCollection.remove_greater(spaceMarine);
                        case "remove_lower" -> ManagerOfCollection.remove_lower(spaceMarine);
                    }
                } else if (line.split(" ")[0].equals("execute_script")
                        && line.split(" ")[1].equals(ExecuteScript.getPath())) { System.out.println("An attempt to recursively call the script was stopped."); }
                else { commandInvoker.Invoke(line.split(" ")); }
                }
            }
        catch (IOException e) {
            System.out.println("������! " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void history() { // TODO ����� ������ ��� 11 ���������, ��������� ��������� history � ������
        if (commandInvoker.invokerListOfCommand.size() >= 11) {
            for (int i = commandInvoker.invokerListOfCommand.size() - 1; i > commandInvoker.invokerListOfCommand.size() - 11; i--) {
                System.out.println(commandInvoker.invokerListOfCommand.get(i));
            }
        }
        else {
            System.out.println("There are not enough elements to output the last 11 elements. Current number of items: " + commandInvoker.invokerListOfCommand.size());
        }
    }

    public void remove_all_by_health(String health) {
        double HP;
        HP = Double.parseDouble(health);

        ManagerOfCollection.remove_all_by_health(HP);
    }

    public void max_by_melee_weapon() {
        ManagerOfCollection.max_by_melee_weapon();
    }

    public void print_unique_chapter() {
        ManagerOfCollection.print_unique_chapter();
    }

}
