package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

import java.util.Arrays;

public class History extends Command{
    private final Receiver commandReceiver;

    public History(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.history();

    }

    @Override
    protected void writeInfo() {
        System.out.println("The history command outputs the last 11 commands.");
    }
}
