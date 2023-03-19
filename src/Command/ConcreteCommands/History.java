package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

import java.util.Arrays;

public class History extends Command{
    private final Receiver commandReceiver;

    public History(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 1) {
            System.out.println(Arrays.toString(args));
            System.out.println("Введены лишнее аргументы. Команда history не требует аргументов.");
        }
        commandReceiver.history();

    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда history выводит последние 11 команд.");
    }
}
