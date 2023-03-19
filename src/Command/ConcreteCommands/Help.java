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
            System.out.println("¬ведены лишнее аргументы.  оманда help не требует аргументов.");
        }
        commandReceiver.help();

    }

    @Override
    protected void writeInfo() {
        System.out.println(" оманда help выводит справку по всем доступным командам");
    }
}
