package Command.ConcreteCommands;

import BaseObjects.SpaceMarine;
import Command.Command;
import Command.Receiver;
import Command.ClientReceiver;

public class RemoveLower extends Command {
    private final Receiver commandReceiver;
    private final ClientReceiver clientReceiver;

    public RemoveLower (Receiver commandReceiver, ClientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
//        commandReceiver.remove_lower(this.getSpaceMarineFromClient());
        commandReceiver.remove_lower((SpaceMarine) this.getExtraDataFromClient());
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