package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class RemoveAllByHealth extends Command {
    private final Receiver commandReceiver;

    public RemoveAllByHealth (Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.remove_all_by_health(this.getDoubleFromClient());
    }
    // TODO: readers wrapper-only
    @Override
    protected void writeInfo() {
        System.out.println("������� remove_all_by_health. ���������: remove_all_by_health health � " +
                "������� �� ��������� ��� ��������, �������� ���� health �������� ������������ ���������.");
    }
}