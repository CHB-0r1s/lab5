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
            Socket clientSocket = connectToServer();
            Invoker commandInvoker = new Invoker();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            sendingCommand(commandInvoker, clientSocket, writer);
            String getMsg = reader.readLine().replaceAll("@", "\n");
            System.out.println(getMsg);

        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static void sendingCommand(Invoker commandInvoker, Socket clientSocket, BufferedWriter writer)
    {
        while (true)
        {
            try (Scanner scanner = new Scanner(System.in))
            {
                //while (scanner.hasNextLine()) {
                Command command = commandInvoker.invokeForClient(scanner.nextLine().trim().split("\s+"));
                if (command != null)
                {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                    objectOutputStream.writeObject(command);
                    writer.newLine();
                    writer.flush();
                    return;
                }
                //}
            } catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    private static Socket connectToServer()
    {
        while (true)
        {
            String host = GettingHost.getHost();
            int port = GettingPort.getPort();
            try
            {
                return new Socket(host, port);
            } catch (UnknownHostException | ConnectException e)
            {
                System.out.println("No connection.");
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}