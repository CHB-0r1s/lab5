package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class RemoveGreater extends Command {
    private final Receiver commandReceiver;

    public RemoveGreater (Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.remove_greater(this.getSpaceMarineFromClient());
    }

    @Override
    protected void writeInfo() {
        System.out.println("The remove_greater command is to remove all items from the collection that exceed the specified one.");
    }
}