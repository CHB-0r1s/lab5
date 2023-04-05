package ClientServer;

import BaseObjects.SpaceMarine;
import Command.Command;

import java.io.*;
import java.net.*;

public class Server
{
    public static void main(String[] args) throws IOException
    {
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
                SpaceMarine spaceMarineFromClient = command.getSpaceMarineFromClient();
                if (spaceMarineFromClient != null) {
                    // команда с креатором
                }
                System.out.println(spaceMarineFromClient);
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
