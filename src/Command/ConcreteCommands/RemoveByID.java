package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class RemoveByID extends Command {
    private final Receiver commandReceiver;

    public RemoveByID (Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {

        if (args.length == 2) { commandReceiver.remove_by_id(args[1]); }
        else { System.out.println("������������ ���������� ���������� ��� ������ �������. ��� ������� �������� help."); }
    }

    @Override
    protected void writeInfo() {
        System.out.println("������� remove_by_id. ���������: remove_by_id id � ������� ������� �� ��������� �� ��� id.");
    }
}