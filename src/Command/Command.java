package Command;

import java.io.IOException;
import java.io.Serializable;

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
