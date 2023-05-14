package Utils.PasswordUtils.MyReaders;

import Utils.MyReaders.MyStringReader;

public class MyLoginReader
{
    public static String read()
    {
        return MyStringReader.read("Write login: ", false);
    }
}
