package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Update extends Command {
    private final Receiver commandReceiver;

    public Update(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.update(this.getLongFromClient(), this.getSpaceMarineFromClient());
    }

    @Override
    protected void writeInfo() {
        System.out.println("The update command updates the value of the collection element whose id is equal to the specified one.");
    }
}
