package ClientServer;

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

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String request = reader.readLine();
            System.out.println(request);
            if (request.equals("exit"))
            {
                clientSocket.close();
            }
        }
    }
}
