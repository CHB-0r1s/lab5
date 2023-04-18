package ClientServer;

import Command.Command;
import Command.Invoker;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client
{
    public static void main(String[] args)
    {

        try
        {
            Socket clientSocket = getConnection();
            Invoker commandInvoker = new Invoker();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            sendingCommand(commandInvoker, clientSocket, writer);
            String getMsg = reader.readLine().replaceAll("@", "\n");
            System.out.println(getMsg);

        }
        catch (IOException e)
        {
            System.out.println("Something went wrong...");
            System.exit(-1);
        }
    }

    private static void sendingCommand(Invoker commandInvoker, Socket clientSocket, BufferedWriter writer)
    {
        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                Command command = commandInvoker.invokeForClient(scanner.nextLine().trim().split("\s+"));
                if (command != null)
                {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                    objectOutputStream.writeObject(command);
                    writer.newLine();
                    writer.flush();
                    return;
                }
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Socket getConnection() throws IOException
    {
        while (true)
        {
            String host = MyHostReader.read("Write a host (in format IPv4):");
            int port = MyPortReader.read("Write a port (in integer format, more than 1024):");

            try
            {
                return new Socket(host, port);
            } catch (UnknownHostException | ConnectException e)
            {
                System.out.println("No connection.");
            }
        }
    }
}