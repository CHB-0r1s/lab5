package Command;

import java.io.IOException;
import java.io.Serializable;

public abstract class Command implements Serializable
{
    protected abstract void execute(String[] args) throws IOException;
    protected abstract void writeInfo();
}
