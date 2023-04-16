package Command;

import BaseObjects.SpaceMarine;
import Command.ClientReceiver;
import Command.Command;
import Command.Invoker;
import Utils.MyReaders.MyFloatReader;
import Utils.MyReaders.MyLongReader;
import Utils.MyReaders.MyPrimDoubleReader;
import Utils.SpaceMarineCreator;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SettingExtraDataFromClient
{
    public static void setFloatFromClient(Command command)
    {
        command.setExtraDataFromClient(MyFloatReader.read("Enter in float format: "));
    }
    public static void setLongFromClient(Command command)
    {
        command.setExtraDataFromClient(MyLongReader.read("Enter ID in long format: "));
    }

    public static void setLongFromClient(long longFromClient, Command command)
    {
        command.setExtraDataFromClient(longFromClient);
    }

    public static void setDoubleFromClient(Command command)
    {
        command.setExtraDataFromClient(MyPrimDoubleReader.read("Enter HP in double format: "));
    }

    public static void setDoubleFromClient(double doubleFromClient, Command command)
    {
        command.setExtraDataFromClient(doubleFromClient);
    }

    public static void setSpaceMarineFromClient(Command command)
    {
        command.setExtraDataFromClient(SpaceMarineCreator.createSpaceMarine());
    }

    public static void setSpaceMarineFromClient(SpaceMarine spaceMarineFromClient, Command command)
    {
        command.setExtraDataFromClient(spaceMarineFromClient);
    }

    public static void setCommandsFromScript(String fileName, Command command) throws FileNotFoundException
    {
        Invoker invoker = new Invoker();
        ClientReceiver clientReceiver = new ClientReceiver(invoker);
        command.setExtraDataFromClient(clientReceiver.getCommandsFromScript(fileName));
    }
}
