package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.clientReceiver;

import java.io.IOException;

public class Exit extends Command{
    private final Receiver commandReceiver;
    private final clientReceiver clientReceiver;

    public Exit(Receiver commandReceiver, clientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
        }

        @Override
        public void execute() throws IOException {
            commandReceiver.exit();
        }

    @Override
    public Command clientExecute() {
        return clientReceiver.exit();
    }

    @Override
        protected void writeInfo() {
            System.out.println("The exit command terminates the program without saving to a file");
        }


}
