package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Exit extends Command{
    private final Receiver commandReceiver;

    public Exit(Receiver commandReceiver) {
            this.commandReceiver = commandReceiver;
        }

        @Override
        protected void execute(String[] args) {
            if (args.length > 1) {
                System.out.println("Введены лишнее аргументы. Команда exit не требует аргументов.");
            }
            commandReceiver.exit();
        }

        @Override
        protected void writeInfo() {
            System.out.println("Команда exit завершает программу бещ сохранения в файл");
        }


}
