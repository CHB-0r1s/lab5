package ClientServer;

import BaseObjects.SpaceMarine;
import Command.Command;
import Utils.ManagerOfCollection;

import java.io.*;
import java.net.*;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ManagerOfCollection.createMyCollection();
        if (args[0].length() > 0) {
            ManagerOfCollection.fillFromXml(args[0]);
        }
        int port = GettingPort.getPort();

        ServerSocket serverSocket = new ServerSocket(port);

        while (true)
        {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted");

            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

            try
            {
                Command command = (Command) objectInputStream.readObject();
                // команда реализовалась
                command.execute();
                }
            catch (ClassNotFoundException e)
            {
                System.out.println(e);
            }

            catch (IllegalStateException | NullPointerException ex) {
                System.out.println("There is no command " + ". For reference, use Ц help");
            }
        }
    }
}
