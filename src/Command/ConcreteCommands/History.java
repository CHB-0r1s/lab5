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
    protected void execute(String[] args) {
        if (args.length > 1) {
            System.out.println(Arrays.toString(args));
            System.out.println("Invalid number of arguments: expected 0");
        }
        commandReceiver.history();

    }

    @Override
    protected void writeInfo() {
        System.out.println("The history command outputs the last 11 commands.");
    }
}
