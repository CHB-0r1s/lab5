package ClientServer;

import Command.Command;
import Command.Invoker;
import User.User;
import User.UserCreator;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client
{
    public static void main(String[] args)
    {
        String host = MyHostReader.read("Write a host (in format IPv4):");
        int port = MyPortReader.read("Write a port (in integer format, more than 1024):");
        Scanner scanner = new Scanner(System.in);
        boolean firstTime = true;

        while (true)
        {
            try
            {
                Socket clientSocket = new Socket(host, port);

                Invoker commandInvoker = new Invoker();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(clientSocket.getOutputStream()));
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                if(firstTime)
                {
                    sendingUser(clientSocket, writer, scanner);
                    firstTime = false;
                }
                if(getResponse(reader))
                {
                    sendingCommand(commandInvoker, clientSocket, writer, scanner);

                    String getMsg = reader.readLine().replaceAll("@", "\n");
                    System.out.println(getMsg);
                    clientSocket.close();
                    Thread.sleep(1000);
                }
                else
                {
                    System.out.println("You are not accepted.");
                }

            } catch (IOException e)
            {
                System.out.println("Something went wrong...");
                System.exit(-1);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    private static void sendingCommand(Invoker commandInvoker, Socket clientSocket, BufferedWriter writer, Scanner scanner)
    {
        try{
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
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static Socket getConnection(String host, int port) throws IOException
    {
        while (true)
        {
            try
            {
                return new Socket(host, port);
            } catch (UnknownHostException | ConnectException e)
            {
                System.out.println("No connection.");
            }
        }
    }

    private static void sendingUser(Socket clientSocket, BufferedWriter writer, Scanner scanner)
    {
        User user;
        System.out.println("Do you want to log in or sign up?");
        while (true)
        {
            String logOrSign = scanner.nextLine();
            if (logOrSign != null && (logOrSign.toLowerCase().contains("log") || logOrSign.toLowerCase().contains("sign")))
            {
                if (logOrSign.toLowerCase().contains("log"))
                {
                    user = UserCreator.createFromConsole(false);
                    break;
                }
                if (logOrSign.toLowerCase().contains("sign"))
                {
                    user = UserCreator.createFromConsole(true);
                    break;
                }
            }
            else
            {
                System.out.println("Incorrect input. Try again.");
            }
        }
        try
        {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            objectOutputStream.writeObject(user);
            writer.newLine();
            writer.flush();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static boolean getResponse(BufferedReader reader) throws IOException
    {
        boolean response = Boolean.valueOf(reader.readLine());
        return response;
    }
}