package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.clientReceiver;

public class Show extends Command {
    private final Receiver commandReceiver;
    private final clientReceiver clientReceiver;

    public Show(Receiver commandReceiver, clientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.show();
    }

    @Override
    public Command clientExecute() {
        return clientReceiver.show();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The show command outputs all the elements of the collection in a string representation");
    }
}
