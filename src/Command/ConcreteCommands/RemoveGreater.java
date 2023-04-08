package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.ClientReceiver;

public class RemoveGreater extends Command {
    private final Receiver commandReceiver;
    private final ClientReceiver clientReceiver;

    public RemoveGreater (Receiver commandReceiver, ClientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.remove_greater(this.getSpaceMarineFromClient());
    }

    @Override
    public Command clientExecute() {
        return clientReceiver.remove_greater();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The remove_greater command is to remove all items from the collection that exceed the specified one.");
    }
}