package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

public class MaxByMeleeWeapon extends Command{
    private final Receiver commandReceiver;

    public MaxByMeleeWeapon(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.max_by_melee_weapon();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The max_by_melee_weapon command outputs any object from the collection, " +
                "the value of the MeleeWeapon field of which is the maximum");
    }
}
