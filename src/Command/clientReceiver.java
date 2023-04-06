package Command;

import BaseObjects.SpaceMarine;
import Command.ConcreteCommands.ExecuteScript;
import Command.ConcreteCommands.Help;
import Utils.ManagerOfCollection;
import Utils.SpaceMarineCreator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class clientReceiver implements Serializable {
    public final Invoker commandInvoker;

    public clientReceiver(Invoker commandInvoker) {
        this.commandInvoker = commandInvoker;
    }

    public Command help() {
        return commandInvoker.invokerHashMap.get("help");
    }
    public Command info() {
        return commandInvoker.invokerHashMap.get("info");
    }
    public Command show() {
        return commandInvoker.invokerHashMap.get("show");
    }
    public Command clear() {
        return commandInvoker.invokerHashMap.get("clear");
    }
    public Command history() {
        return commandInvoker.invokerHashMap.get("history");
    }
    public Command max_by_melee_weapon() {
        return commandInvoker.invokerHashMap.get("max_by_melee_weapon");
    }
    public Command print_unique_chapter() {
        return commandInvoker.invokerHashMap.get("print_unique_chapter");
    }
    public Command add() {
        Command command = commandInvoker.invokerHashMap.get("add");
        command.setSpaceMarineFromClient();
        System.out.println("An element with ID has been created: " + command.getSpaceMarineFromClient().getId());
        return command;
    }

    public Command update() {
        Command command = commandInvoker.invokerHashMap.get("update");
        command.setLongFromClient();
        command.setSpaceMarineFromClient();
        return command;
    }

    public Command remove_by_id() {
        Command command = commandInvoker.invokerHashMap.get("remove_by_id");
        command.setLongFromClient();
        return command;
    }

    public Command exit() {
        return commandInvoker.invokerHashMap.get("exit");
        /* System.out.println("Save you progress in collection? [yes/no]");

        Scanner exitScanner = new Scanner(System.in);
        while (true) {
            if (exitScanner.hasNextLine()) {
                String ans = exitScanner.nextLine();
                if (ans.equals("yes")) {
                    ManagerOfCollection.save();
                    break;
                } else if (ans.equals("no")) {
                    break;
                }
                else {System.out.println("Invalid answer. [yes/no]");}
            }
        }*/
    }

    public Command remove_greater() {
        Command command = commandInvoker.invokerHashMap.get("remove_greater");
        command.setSpaceMarineFromClient();
        return command;
    }

    public Command remove_lower() {
        Command command = commandInvoker.invokerHashMap.get("remove_lower");
        command.setSpaceMarineFromClient();
        return command;
    }

    public void execute_script(String path) throws IOException {
        // Процедуру запихивания в поле для команд писать тут.
    }


    public Command remove_all_by_health() {
        Command command = commandInvoker.invokerHashMap.get("remove_all_by_health");
        command.setDoubleFromClient();
        return command;
    }
}
