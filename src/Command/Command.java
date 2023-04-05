package Command;

import BaseObjects.SpaceMarine;
import Utils.MyReaders.MyFloatReader;
import Utils.MyReaders.MyLongReader;
import Utils.MyReaders.MyPrimDoubleReader;
import Utils.SpaceMarineCreator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Command implements Serializable
{
    public abstract void execute() throws IOException;
    protected abstract void writeInfo();
    private float floatFromClient;
    private long longFromClient;
    private double doubleFromClient;
    private SpaceMarine spaceMarineFromClient;
    private ArrayList<Command> commandsFromScript;

    public void setFloatFromClient()
    {
        this.floatFromClient = MyFloatReader.read("Enter in float format: ");
    }
    public void setLongFromClient()
    {
        this.longFromClient = MyLongReader.read("Enter ID in long format: ");
    }

    public void setLongFromClient(long longFromClient)
    {
        this.longFromClient = longFromClient;
    }

    public void setDoubleFromClient() {this.doubleFromClient = MyPrimDoubleReader.read("Enter HP in double format: ");
    }

    public void setDoubleFromClient(double doubleFromClient)
    {
        this.doubleFromClient = doubleFromClient;
    }

    public void setSpaceMarineFromClient()
    {
        this.spaceMarineFromClient = SpaceMarineCreator.createSpaceMarine();
    }

    public void setSpaceMarineFromClient(SpaceMarine spaceMarineFromClient)
    {
        this.spaceMarineFromClient = spaceMarineFromClient;
    }

    public void setCommandsFromScript(String fileName) throws FileNotFoundException
    {
        //this.commandsFromScript = Invoker.invokeCommandFromScriptForClient(fileName);
    }

    public float getFloatFromClient()
    {
        return floatFromClient;
    }

    public long getLongFromClient()
    {
        return longFromClient;
    }
    public double getDoubleFromClient() {return doubleFromClient;}

    public SpaceMarine getSpaceMarineFromClient()
    {
        return spaceMarineFromClient;
    }

    public ArrayList<Command> getCommandsFromScript()
    {
        return commandsFromScript;
    }
}
