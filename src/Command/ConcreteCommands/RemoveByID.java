package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.ClientReceiver;

public class RemoveByID extends Command {
    private final Receiver commandReceiver;
    private final ClientReceiver clientReceiver;

    public RemoveByID (Receiver commandReceiver, ClientReceiver clientReceiver) {
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