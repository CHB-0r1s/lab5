package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Update extends Command {
    private final Receiver commandReceiver;

    public Update(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length == 2) { commandReceiver.update(args[0]); }
        else { System.out.println("������������ ���������� ���������� ��� ������ �������. ��� ������� �������� help."); }
    }

    @Override
    protected void writeInfo() {
        System.out.println("������� update ��������� �������� �������� ���������, id �������� ����� ���������");
    }
}
