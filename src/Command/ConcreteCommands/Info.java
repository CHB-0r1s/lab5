package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.clientReceiver;

public class Info extends Command {
    private final Receiver commandReceiver;
    private final clientReceiver clientReceiver;

    public Info(Receiver commandReceiver, clientReceiver clientReceiver) {

        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.info();
    }

    @Override
    public Command clientExecute() { return clientReceiver.info(); }

    @Override
    protected void writeInfo() {
        System.out.println("The info command displays information about the collection (type, initialization date, number of items, etc.)");
    }
}
