package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.clientReceiver;

public class RemoveGreater extends Command {
    private final Receiver commandReceiver;
    private final clientReceiver clientReceiver;

    public RemoveGreater (Receiver commandReceiver, clientReceiver clientReceiver) {
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