package ClientServer;

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
            while (true)
            {
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(clientSocket.getOutputStream()));
                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine();
                writer.write(line);
                writer.newLine();
                writer.flush();
            }
        }
        catch (UnknownHostException e)
        {
            System.out.println("No connection.");
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
