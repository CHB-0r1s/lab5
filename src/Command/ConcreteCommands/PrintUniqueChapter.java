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
    public void execute() {
        commandReceiver.print_unique_chapter();

    }

    @Override
    protected void writeInfo() {
        System.out.println("The print_unique_chapter command outputs the unique values of the chapter field of all items in the collection");
    }
}
