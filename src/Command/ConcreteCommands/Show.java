package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Show extends Command {
    private final Receiver commandReceiver;

    public Show(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Invalid number of arguments: expected 0");
        }
        commandReceiver.show();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The show command outputs all the elements of the collection in a string representation");
    }
}
