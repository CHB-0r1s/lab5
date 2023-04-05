package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Add extends Command {
    private final Receiver commandReceiver;

    public Add(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.add(this.getSpaceMarineFromClient());
    }

    @Override
    protected void writeInfo() {
        System.out.println("The add command adds a new item to the collection");
    }
}
