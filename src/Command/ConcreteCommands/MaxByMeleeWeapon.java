package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

import java.util.Arrays;

public class MaxByMeleeWeapon extends Command{
    private final Receiver commandReceiver;

    public MaxByMeleeWeapon(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) {
        if (args.length > 1) {
            System.out.println(Arrays.toString(args));
            System.out.println("������� ������ ��������� ��� ������ �������. ������� max_by_melee_weapon �� ������� ����������.");
        }
        commandReceiver.max_by_melee_weapon();

    }

    @Override
    protected void writeInfo() {
        System.out.println("������� max_by_melee_weapon ������� ����� ������ �� ���������, " +
                "�������� ���� meleeWeapon �������� �������� ������������");
    }
}
