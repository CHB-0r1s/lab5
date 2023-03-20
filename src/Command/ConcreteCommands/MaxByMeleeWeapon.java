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
            System.out.println("Invalid number of arguments: expected 0");
        }
        commandReceiver.max_by_melee_weapon();

    }

    @Override
    protected void writeInfo() {
        System.out.println("The max_by_melee_weapon command outputs any object from the collection, " +
                "the value of the MeleeWeapon field of which is the maximum");
    }
}
