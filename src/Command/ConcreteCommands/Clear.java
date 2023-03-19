package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class Clear extends Command {
    private final Receiver commandReceiver;

    public Clear(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 1) { commandReceiver.clear(); }
        else { System.out.println("������� ������ ���������. ������� clear �� ������� ����������."); }
    }

    @Override
    protected void writeInfo() {
        System.out.println("������� clear ������� ���������");
    }
}
