package Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Invoker {
    public HashMap<String, Command> invokerHashMap = new HashMap<String, Command>();
    public ArrayList<String> invokerListOfCommand = new ArrayList<>();

    public void Invoke(String[] command_name) throws IOException {
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
}
