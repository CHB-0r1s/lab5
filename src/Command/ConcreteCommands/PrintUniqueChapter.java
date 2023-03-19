package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

import java.util.Arrays;

public class PrintUniqueChapter extends Command{
    private final Receiver commandReceiver;

    public PrintUniqueChapter(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 1) {
            System.out.println(Arrays.toString(args));
            System.out.println("Введены лишнее аргументы или лишние пробелы. Команда print_unique_chapter не требует аргументов.");
        }
        commandReceiver.print_unique_chapter();

    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда print_unique_chapter выводит уникальные значения поля chapter всех элементов в коллекции");
    }
}
