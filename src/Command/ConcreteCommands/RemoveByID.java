package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class RemoveByID extends Command {
    private final Receiver commandReceiver;

    public RemoveByID (Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {

        if (args.length == 2) { commandReceiver.remove_by_id(args[1]); }
        else { System.out.println("Некорректное количество аргументов или лишние пробелы. Для справки напишите help."); }
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда remove_by_id. Синтаксис: remove_by_id id – удалить элемент из коллекции по его id.");
    }
}