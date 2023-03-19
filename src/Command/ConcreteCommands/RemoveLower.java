package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class RemoveLower extends Command {
    private final Receiver commandReceiver;

    public RemoveLower (Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 2) {
            System.out.println("Введен не нужный аргумент. Команда приведена к базовой команде remove_lower.");
        }
        commandReceiver.remove_lower();
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда remove_lower – удалить из коллекции все элементы, меньшие, чем заданный.");
    }
}