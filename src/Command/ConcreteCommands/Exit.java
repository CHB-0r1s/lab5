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
                System.out.println("Invalid number of arguments: expected 0");
            }
            commandReceiver.exit();
        }

        @Override
        protected void writeInfo() {
            System.out.println("The exit command terminates the program without saving to a file");
        }


}
