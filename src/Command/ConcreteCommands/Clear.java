package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.ClientReceiver;

public class Clear extends Command {
    private final Receiver commandReceiver;
    private final ClientReceiver clientReceiver;

    public Clear(Receiver commandReceiver, ClientReceiver clientReceiver) {
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
