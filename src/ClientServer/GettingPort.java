package ClientServer;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface GettingPort
{
    static int getPort()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Write a port (in integer format, more than 1024):");
        try
        {
            int number = reader.nextInt();
            return number;
        }
        catch (InputMismatchException e)
        {
            System.out.println("Not right input. Try again.");
            return getPort();
        }
    }
}
