package Command.ConcreteCommands;

import BaseObjects.SpaceMarine;
import Command.Command;
import Command.Receiver;
import Command.ClientReceiver;

import java.io.IOException;

public class RemoveGreater extends Command {
    private final Receiver commandReceiver;
    private final ClientReceiver clientReceiver;

    public RemoveGreater (Receiver commandReceiver, ClientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() throws IOException {
//        commandReceiver.remove_greater(this.getSpaceMarineFromClient());
        commandReceiver.remove_greater((SpaceMarine) this.getExtraDataFromClient());
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