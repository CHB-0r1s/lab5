package ClientServer;

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
                System.out.println(command);
            }
            catch (ClassNotFoundException e)
            {
                System.out.println(e);
            }

//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(clientSocket.getInputStream()));
//            String request = reader.readLine();
//            System.out.println(request);
//            if (request.equals("exit"))
//            {
//                clientSocket.close();
//            }
        }
    }
}
