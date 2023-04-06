package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.clientReceiver;

public class RemoveAllByHealth extends Command {
    private final Receiver commandReceiver;
    private final clientReceiver clientReceiver;

    public RemoveAllByHealth (Receiver commandReceiver, clientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.remove_all_by_health(this.getDoubleFromClient());
    }

    @Override
    public Command clientExecute() {
        return clientReceiver.remove_all_by_health();
    }

    // TODO: readers wrapper-only
    @Override
    protected void writeInfo() {
        System.out.println("Команда remove_all_by_health. Синтаксис: remove_all_by_health health – " +
                "удалить из коллекции все элементы, значение поля health которого эквивалентно заданному.");
    }
}