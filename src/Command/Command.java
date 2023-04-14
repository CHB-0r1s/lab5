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
    public abstract Command clientExecute();
    protected abstract void writeInfo();
    private Object extraDataFromClient;
//    private float floatFromClient;
//    private long longFromClient;
//    private double doubleFromClient;
//    private SpaceMarine spaceMarineFromClient;
//    private ArrayList<Command> commandsFromScript;

    public void setExtraDataFromClient(Object extraDataFromClient)
    {
        this.extraDataFromClient = extraDataFromClient;
    }

    public Object getExtraDataFromClient()
    {
        return extraDataFromClient;
    }
}
