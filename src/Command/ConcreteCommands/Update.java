package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Update extends Command {
    private final Receiver commandReceiver;

    public Update(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length == 2) { commandReceiver.update(args[1]); }
        else { System.out.println("Invalid number of arguments: expected 1, found 0."); }
    }

    @Override
    protected void writeInfo() {
        System.out.println("The update command updates the value of the collection element whose id is equal to the specified one.");
    }
}
