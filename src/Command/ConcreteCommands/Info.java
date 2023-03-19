package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Info extends Command {
    private final Receiver commandReceiver;

    public Info(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Введены лишнее аргументы. Команда info не требует аргументов.");
        }
        commandReceiver.info();
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда info выводит информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }
}
