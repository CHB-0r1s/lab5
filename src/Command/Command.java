package Command;

import java.io.IOException;

public abstract class Command {
    protected abstract void execute(String[] args) throws IOException;
    protected abstract void writeInfo();
}
