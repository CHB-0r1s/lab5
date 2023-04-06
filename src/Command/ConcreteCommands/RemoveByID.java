package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.clientReceiver;

public class RemoveByID extends Command {
    private final Receiver commandReceiver;
    private final clientReceiver clientReceiver;

    public RemoveByID (Receiver commandReceiver, clientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.remove_by_id(this.getLongFromClient());
    }

    @Override
    public Command clientExecute() {
        return clientReceiver.remove_by_id();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The remove_by_id command. Syntax: remove_by_id id – remove an item from the collection by its id.");
    }
}