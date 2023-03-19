package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class RemoveGreater extends Command {
    private final Receiver commandReceiver;

    public RemoveGreater (Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 2) {
            System.out.println("Введен не нужный аргумент. Команда приведена к базовой команде remove_greater.");
        }
        commandReceiver.remove_greater();
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда remove_greater – удалить из коллекции все элементы, превышающие заданный.");
    }
}