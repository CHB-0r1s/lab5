package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

import java.util.Arrays;

public class Help extends Command{
        private final Receiver commandReceiver;

    public Help(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.help();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The help command displays help for all available commands");
    }
}
