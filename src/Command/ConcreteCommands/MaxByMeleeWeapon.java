package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;
import Command.clientReceiver;

public class MaxByMeleeWeapon extends Command{
    private final Receiver commandReceiver;
    private final clientReceiver clientReceiver;
    public MaxByMeleeWeapon(Receiver commandReceiver, clientReceiver clientReceiver) {
        this.commandReceiver = commandReceiver;
        this.clientReceiver = clientReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.max_by_melee_weapon();
    }

    @Override
    public Command clientExecute() {
        return clientReceiver.max_by_melee_weapon();
    }

    @Override
    protected void writeInfo() {
        System.out.println("The max_by_melee_weapon command outputs any object from the collection, " +
                "the value of the MeleeWeapon field of which is the maximum");
    }
}
