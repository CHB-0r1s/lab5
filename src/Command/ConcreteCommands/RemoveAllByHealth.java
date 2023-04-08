package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.ClientReceiver;

public class RemoveAllByHealth extends Command {
    private final Receiver commandReceiver;
    private final ClientReceiver clientReceiver;

    public RemoveAllByHealth (Receiver commandReceiver, ClientReceiver clientReceiver) {
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