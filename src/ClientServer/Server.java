package ClientServer;

import BaseObjects.SpaceMarine;
import Command.Command;
import Utils.ManagerOfCollection;

import java.io.*;
import java.net.*;
import java.util.Scanner;

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

            File fileName = new File("outServer.txt");

            try
            {
                ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                PrintStream out = new PrintStream(new FileOutputStream(fileName));
                System.setOut(out);

                Scanner scanner = new Scanner(fileName);

                try
                {
                    Command command = (Command) objectInputStream.readObject();
                    // команда реализовалась
                    command.execute();
                    System.out.println(command);
                    out.close();
                    while (scanner.hasNextLine())
                    {
                        writer.write(scanner.nextLine() + "@");
                    }
                    writer.newLine();
                    writer.flush();
                } catch (ClassNotFoundException e)
                {
                    System.out.println(e);
                } catch (IllegalStateException | NullPointerException ex)
                {
                    System.out.println("There is no command " + ". For reference, use Ц help");
                }
            }
            catch (SocketException e)
            {
                System.out.println("Client sent nothing and left.");
            }
        }
    }
}
