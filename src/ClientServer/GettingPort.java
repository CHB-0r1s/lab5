package ClientServer;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface GettingPort
{
    static int getPort()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Write a port (in integer format, more than 1024):");
        while (true)
        {
            try
            {
                int number = reader.nextInt();
                if (number <= 1024)
                {
                    System.out.println("Port must be more than 1024.");
                } else
                {
                    return number;
                }
            } catch (InputMismatchException e)
            {
                System.out.println("Not right input. Try again.");
            }
        }
    }
}
