package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Command.ClientReceiver;
public class ExecuteScript extends Command {
    private final Receiver commandReceiver;
    private final ClientReceiver clientReceiver = null;
    private static String path;

    public ExecuteScript(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() throws StackOverflowError, IOException {
        ArrayList<Command> commands = (ArrayList<Command>) this.getExtraDataFromClient();
        for (Command value : commands) {
            value.execute();
        }
    }

    @Override
    public Command clientExecute() {

        return clientReceiver.execute_script(getFileName());
    }
    private final String getFileName()
    {
        System.out.println("Write file name:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return line;
    }

    //idk how to change this cringe story

    @Override
    protected void writeInfo() {
        System.out.println("The execute_script command. Syntax: execute_script file_name – read and execute the script from the specified file. " +
                "The script contains commands in the same form as they are entered by the user in interactive mode.");
    }

    public static String getPath() {
        return path;
    }

}
