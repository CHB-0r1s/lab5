package User;

import Utils.PasswordUtils.MyReaders.MyLoginReader;
import Utils.PasswordUtils.MyReaders.MyPasswordReader;

public class UserCreator
{
    public static User createFromConsole(boolean newable)
    {
        User user = new User(MyLoginReader.read(), MyPasswordReader.read(), newable);
        return user;
    }

    void createFromDataBase()
    {
        //in another class, 'cause this class should be on client part??
    }
}
