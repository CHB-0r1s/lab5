package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

import java.io.IOException;

public class Exit extends Command{
    private final Receiver commandReceiver;

    public Exit(Receiver commandReceiver) {
            this.commandReceiver = commandReceiver;
        }

        @Override
        public void execute() throws IOException {
            commandReceiver.exit();
        }

        @Override
        protected void writeInfo() {
            System.out.println("The exit command terminates the program without saving to a file");
        }


}
