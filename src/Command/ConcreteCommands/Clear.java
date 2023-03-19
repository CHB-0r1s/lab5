package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Clear extends Command {
    private final Receiver commandReceiver;

    public Clear(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 1) { commandReceiver.clear(); }
        else { System.out.println("Введены лишнее аргументы. Команда clear не требует аргументов."); }
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда clear очищает коллекцию");
    }
}
