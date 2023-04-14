package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.ClientReceiver;

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
