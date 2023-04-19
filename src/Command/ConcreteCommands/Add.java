package Command.ConcreteCommands;

import BaseObjects.SpaceMarine;
import Command.Command;
import Command.Receiver;
import Command.ClientReceiver;

import java.io.IOException;

public class Add extends Command {
    private final Receiver commandReceiver;
    private final ClientReceiver clientReceiver;

    public Add(Receiver commandReceiver, ClientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() throws IOException {
//        commandReceiver.add(this.getSpaceMarineFromClient());
        commandReceiver.add((SpaceMarine) this.getExtraDataFromClient());
    }

    @Override
    public Command clientExecute() {
        return clientReceiver.add();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The add command adds a new item to the collection");
    }
}
