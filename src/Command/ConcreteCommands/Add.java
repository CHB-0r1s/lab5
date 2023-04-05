package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Add extends Command {
    private final Receiver commandReceiver;

    public Add(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Invalid number of arguments: expected 0 and fields below");
        }
        commandReceiver.add(this.getSpaceMarineFromClient());
    }

    @Override
    protected void writeInfo() {
        System.out.println("The add command adds a new item to the collection");
    }
}
