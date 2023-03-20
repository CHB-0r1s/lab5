package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class RemoveAllByHealth extends Command {
    private final Receiver commandReceiver;

    public RemoveAllByHealth (Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length == 2) { commandReceiver.remove_all_by_health(args[1]); }
        else { System.out.println("Invalid number of arguments: expected 1, found 0."); }
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда remove_all_by_health. Синтаксис: remove_all_by_health health – " +
                "удалить из коллекции все элементы, значение поля health которого эквивалентно заданному.");
    }
}