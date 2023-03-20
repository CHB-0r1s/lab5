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
    protected void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Invalid number of arguments: expected 0");
        }
        commandReceiver.help();

    }

    @Override
    protected void writeInfo() {
        System.out.println("The help command displays help for all available commands");
    }
}
