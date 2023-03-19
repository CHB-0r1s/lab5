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
                System.out.println("������� ������ ���������. ������� exit �� ������� ����������.");
            }
            commandReceiver.exit();
        }

        @Override
        protected void writeInfo() {
            System.out.println("������� exit ��������� ��������� ��� ���������� � ����");
        }


}
