package Command.ConcreteCommands;

import BaseObjects.SpaceMarine;
import Command.Command;
import Command.Receiver;
import Command.ClientReceiver;

import java.util.ArrayList;

public class Update extends Command {
    private final Receiver commandReceiver;
    private final ClientReceiver clientReceiver;

    public Update(Receiver commandReceiver, ClientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
//        commandReceiver.update(this.getLongFromClient(), this.getSpaceMarineFromClient());
//        commandReceiver.update();
        ArrayList<Object> buffer = (ArrayList<Object>) this.getExtraDataFromClient();
        commandReceiver.update((Long) buffer.get(0), (SpaceMarine) buffer.get(1));
    }

    @Override
    public Command clientExecute() {
        return clientReceiver.update();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The update command updates the value of the collection element whose id is equal to the specified one.");
    }
}
