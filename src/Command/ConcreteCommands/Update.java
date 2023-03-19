package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Update extends Command {
    private final Receiver commandReceiver;

    public Update(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length == 2) { commandReceiver.update(args[0]); }
        else { System.out.println("Некорректное количество аргументов или лишние пробелы. Для справки напишите help."); }
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда update обновляет значение элемента коллекции, id которого равен заданному");
    }
}
