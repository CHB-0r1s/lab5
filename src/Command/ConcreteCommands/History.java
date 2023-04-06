package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.clientReceiver;

import java.util.Arrays;

public class History extends Command{
    private final Receiver commandReceiver;
    private final clientReceiver clientReceiver;

    public History(Receiver commandReceiver, clientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.history();

    }

    @Override
    public Command clientExecute() {
        return clientReceiver.history();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The history command outputs the last 11 commands.");
    }
}
