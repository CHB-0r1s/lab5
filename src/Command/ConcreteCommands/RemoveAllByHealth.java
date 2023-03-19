package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class RemoveAllByHealth extends Command {
    private final Receiver commandReceiver;

    public RemoveAllByHealth (Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length == 2) { commandReceiver.remove_all_by_health(args[1]); }
        else { System.out.println("������������ ���������� ���������� ��� ������ �������. ��� ������� �������� help."); }
    }

    @Override
    protected void writeInfo() {
        System.out.println("������� remove_all_by_health. ���������: remove_all_by_health health � " +
                "������� �� ��������� ��� ��������, �������� ���� health �������� ������������ ���������.");
    }
}