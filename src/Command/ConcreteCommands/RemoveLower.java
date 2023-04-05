package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class RemoveLower extends Command {
    private final Receiver commandReceiver;

    public RemoveLower (Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.remove_lower(this.getSpaceMarineFromClient());
    }

    @Override
    protected void writeInfo() {
        System.out.println("The remove_lower command is to remove all items smaller than the specified one from the collection.");
    }
}