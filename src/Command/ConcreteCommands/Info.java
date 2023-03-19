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
            System.out.println("������� ������ ���������. ������� info �� ������� ����������.");
        }
        commandReceiver.info();
    }

    @Override
    protected void writeInfo() {
        System.out.println("������� info ������� ���������� � ��������� (���, ���� �������������, ���������� ��������� � �.�.)");
    }
}
