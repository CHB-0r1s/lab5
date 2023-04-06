package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.clientReceiver;

public class Help extends Command{
        private final Receiver commandReceiver;
        private final clientReceiver clientReceiver;

    public Help(Receiver commandReceiver, clientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.help();
    }
    @Override
    public Command clientExecute() {
        return clientReceiver.help();

    }

    @Override
    protected void writeInfo() {
        System.out.println("The help command displays help for all available commands");
    }
}
