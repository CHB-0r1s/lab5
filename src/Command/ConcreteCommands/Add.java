package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.clientReceiver;

public class Add extends Command {
    private final Receiver commandReceiver;
    private final clientReceiver clientReceiver;

    public Add(Receiver commandReceiver, clientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.add(this.getSpaceMarineFromClient());
    }

    @Override
    public Command clientExecute() {
        return clientReceiver.add();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The add command adds a new item to the collection");
    }
}
