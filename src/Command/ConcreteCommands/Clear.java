package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.clientReceiver;

public class Clear extends Command {
    private final Receiver commandReceiver;
    private final clientReceiver clientReceiver;

    public Clear(Receiver commandReceiver, clientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.clear();
    }

    @Override
    public Command clientExecute() {
        return clientReceiver.clear();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The clear command clears the collection.");
    }
}
