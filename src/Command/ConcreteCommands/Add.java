package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Add extends Command {
    private final Receiver commandReceiver;

    public Add(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("������� ������ ���������. ������� add ������� ���� ��������.");
        }
        commandReceiver.add();
    }

    @Override
    protected void writeInfo() {
        System.out.println("������� add ��������� ����� ������� � ���������");
    }
}
