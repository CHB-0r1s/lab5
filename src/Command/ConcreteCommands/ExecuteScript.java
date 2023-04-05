package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ExecuteScript extends Command {
    private final Receiver commandReceiver;
    private static String path;

    public ExecuteScript(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() throws StackOverflowError {
        /*try {
            commandReceiver.execute_script(args[1]); }
            else { System.out.println("Invalid number of arguments: expected 1, found 0."); }
        } catch (StackOverflowError ex) {
            System.out.println("Stack overflow due to cyclic recursion");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

    @Override
    protected void writeInfo() {
        System.out.println("The execute_script command. Syntax: execute_script file_name – read and execute the script from the specified file. " +
                "The script contains commands in the same form as they are entered by the user in interactive mode.");
    }

    public static String getPath() {
        return path;
    }

}
