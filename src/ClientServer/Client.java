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
        int port = GettingPort.getPort();
        try
        {
            Socket clientSocket = new Socket("127.0.0.1", port);
            Invoker commandInvoker = new Invoker();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            sendingCommand(commandInvoker, clientSocket, writer);
            String getMsg = reader.readLine().replaceAll("@", "\n");
            System.out.println(getMsg);

        }
        catch (UnknownHostException e)
        {
            System.out.println("No connection.");
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static void sendingCommand(Invoker commandInvoker, Socket clientSocket, BufferedWriter writer)
    {
        try(Scanner scanner = new Scanner(System.in)) {
            //while (scanner.hasNextLine()) {
                Command command = commandInvoker.invokeForClient(scanner.nextLine().trim().split("\s+"));
                if (command == null)
                {
                    sendingCommand(commandInvoker, clientSocket, writer);
                    return;
                }
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                objectOutputStream.writeObject(command);
                //sends without string after command
                writer.newLine();
                writer.flush();
            //}
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}