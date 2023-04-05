package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class RemoveGreater extends Command {
    private final Receiver commandReceiver;

    public RemoveGreater (Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 2) {
            System.out.println("Invalid number of arguments: expected 0");
        }
        commandReceiver.remove_greater(this.getSpaceMarineFromClient());
    }

    @Override
    protected void writeInfo() {
        System.out.println("The remove_greater command is to remove all items from the collection that exceed the specified one.");
    }
}