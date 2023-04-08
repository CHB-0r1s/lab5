package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.ClientReceiver;

public class PrintUniqueChapter extends Command{
    private final Receiver commandReceiver;
    private final ClientReceiver clientReceiver;
    public PrintUniqueChapter(Receiver commandReceiver, ClientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.print_unique_chapter();

    }

    @Override
    public Command clientExecute() {
        return clientReceiver.print_unique_chapter();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The print_unique_chapter command outputs the unique values of the chapter field of all items in the collection");
    }
}
