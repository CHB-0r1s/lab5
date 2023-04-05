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
    public void execute() throws IOException {
        commandReceiver.save();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The save command is to save the collection to a file.");
    }
}