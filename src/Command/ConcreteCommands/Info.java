package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Info extends Command {
    private final Receiver commandReceiver;

    public Info(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.info();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The info command displays information about the collection (type, initialization date, number of items, etc.)");
    }
}
