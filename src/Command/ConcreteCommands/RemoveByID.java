package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class RemoveByID extends Command {
    private final Receiver commandReceiver;

    public RemoveByID (Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.remove_by_id(this.getLongFromClient());
    }

    @Override
    protected void writeInfo() {
        System.out.println("The remove_by_id command. Syntax: remove_by_id id – remove an item from the collection by its id.");
    }
}