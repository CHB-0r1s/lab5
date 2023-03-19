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
            System.out.println("Введены лишнее аргументы или лишние пробелы. Команда max_by_melee_weapon не требует аргументов.");
        }
        commandReceiver.max_by_melee_weapon();

    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда max_by_melee_weapon выводит любой объект из коллекции, " +
                "значение поля meleeWeapon которого является максимальным");
    }
}
