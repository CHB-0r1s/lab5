package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Clear extends Command {
    private final Receiver commandReceiver;

    public Clear(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.clear();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The clear command clears the collection.");
    }
}
