package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.clientReceiver;

public class RemoveLower extends Command {
    private final Receiver commandReceiver;
    private final clientReceiver clientReceiver;

    public RemoveLower (Receiver commandReceiver, clientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.remove_lower(this.getSpaceMarineFromClient());
    }

    @Override
    public Command clientExecute() {
        return clientReceiver.remove_lower();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The remove_lower command is to remove all items smaller than the specified one from the collection.");
    }
}