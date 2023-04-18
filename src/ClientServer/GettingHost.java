package ClientServer;

import java.util.Scanner;
import java.util.regex.*;

public interface GettingHost
{
    static String getHost()
    {
        Scanner reader = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^((\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])$");
        System.out.println("Write a host (in format IPv4):");
        while (true)
        {
            String line = reader.nextLine();
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches())
            {
                return line;
            } else
            {
                System.out.println("Wrong format. Try again.");
            }
        }
    }
}
