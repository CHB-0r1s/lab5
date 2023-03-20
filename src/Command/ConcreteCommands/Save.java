package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

import java.io.IOException;

public class Save extends Command {
    private final Receiver commandReceiver;

    public Save(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Invalid number of arguments: expected 0");
        }
        commandReceiver.save();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The save command is to save the collection to a file.");
    }
}