package Utils.PasswordUtils.MyReaders;

import Utils.Makers.MyHashMaker;
import Utils.MyReaders.MyStringReader;

import java.security.NoSuchAlgorithmException;

public class MyPasswordReader
{
    public static String read()
    {
        try
        {
            return MyHashMaker.makeIn224(MyStringReader.read("Write password: ", false));
        } catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }
}
