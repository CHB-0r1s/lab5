package Command.ConcreteCommands;

import Command.Command;
import Command.Receiver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ExecuteScript extends Command {
    private final Receiver commandReceiver;
    private static String path;

    public ExecuteScript(Receiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) throws StackOverflowError {
        try {
            if (args.length == 2) { path = args[1]; commandReceiver.execute_script(args[1]); }
            else { System.out.println("������������ ���������� ���������� ��� ������ �������. ��� ������� �������� help."); }
        } catch (StackOverflowError ex) {
            // TODO: ��������� ����������� �������� ����� ������������ �����
            System.out.println("������! ���� ���������� ��-�� ����������� ��������");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void writeInfo() {
        System.out.println("������� execute_script. ���������: execute_script file_name � ������� � ��������� ������ �� ���������� �����. " +
                "� ������� ���������� ������� � ����� �� ����, � ������� �� ������ ������������ � ������������� ������.");
    }

    public static String getPath() {
        return path;
    }

}
