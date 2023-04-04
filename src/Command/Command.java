package Command;

import BaseObjects.SpaceMarine;
import Utils.MyReaders.MyFloatReader;
import Utils.MyReaders.MyLongReader;
import Utils.SpaceMarineCreator;

import java.io.IOException;
import java.io.Serializable;

public abstract class Command implements Serializable
{
    protected abstract void execute(String[] args) throws IOException;
    protected abstract void writeInfo();
    private float floatFromClient;
    private long longFromClient;
    private SpaceMarine spaceMarineFromClient;

    public void setFloatFromClient()
    {
        this.floatFromClient = MyFloatReader.read("Enter in float format:");
    }
    public void setLongFromClient()
    {
        this.longFromClient = MyLongReader.read("Enter ID in long format:");
    }
    public void setSpaceMarineFromClient()
    {
        this.spaceMarineFromClient = SpaceMarineCreator.createSpaceMarine();
    }

    public float getFloatFromClient()
    {
        return floatFromClient;
    }

    public long getLongFromClient()
    {
        return longFromClient;
    }

    public SpaceMarine getSpaceMarineFromClient()
    {
        return spaceMarineFromClient;
    }
}
