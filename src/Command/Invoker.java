package Command;

import Command.ConcreteCommands.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class Invoker implements Serializable
{
    public HashMap<String, Command> invokerHashMap = new HashMap<String, Command>();
    //why is it cannot be static^^^^
    public ArrayList<String> invokerListOfCommand = new ArrayList<>();

    public void invoke(String[] command_name) throws IOException {
        try {
            if (command_name.length > 0) {
                Command command = invokerHashMap.get(command_name[0]);
                invokerListOfCommand.add(command_name[0]);
                command.execute(command_name);
            } else {
                System.out.println("You have not entered a command.");
            }
        } catch (IllegalStateException | NullPointerException ex) {
            System.out.println("There is no command " + command_name[0] + ". For reference, use – help");
        }
    }

    public Command invokeForClient(String[] command_name) throws IOException {
        fillHashMap();
        if (command_name.length > 0 && invokerHashMap.get(command_name[0]) != null) {
            Command command = invokerHashMap.get(command_name[0]);
            invokerListOfCommand.add(command_name[0]);
            return command;
        } else if (command_name.length == 0)
        {
            System.out.println("You have not entered a command.");
            return null;
        } else
        {
            System.out.println("There is no command " + command_name[0] + ". For reference, use – help");
            return null;
        }
    }

    private void fillHashMap()
    {
        Receiver commandReceiver = new Receiver(this);
        invokerHashMap.put("help", new Help(commandReceiver));
        invokerHashMap.put("info", new Info(commandReceiver));
        invokerHashMap.put("add", new Add(commandReceiver));
        invokerHashMap.put("show", new Show(commandReceiver));
        invokerHashMap.put("update", new Update(commandReceiver));
        invokerHashMap.put("remove_by_id", new RemoveByID(commandReceiver));
        invokerHashMap.put("clear", new Clear(commandReceiver));
        invokerHashMap.put("exit", new Exit(commandReceiver));
        invokerHashMap.put("remove_greater", new RemoveGreater(commandReceiver));
        invokerHashMap.put("remove_lower", new RemoveLower(commandReceiver));
        invokerHashMap.put("save", new Save(commandReceiver));
        invokerHashMap.put("execute_script", new ExecuteScript(commandReceiver));
        invokerHashMap.put("history", new History(commandReceiver));
        invokerHashMap.put("remove_all_by_health", new RemoveAllByHealth(commandReceiver));
        invokerHashMap.put("max_by_melee_weapon", new MaxByMeleeWeapon(commandReceiver));
        invokerHashMap.put("print_unique_chapter", new PrintUniqueChapter(commandReceiver));
    }
}
