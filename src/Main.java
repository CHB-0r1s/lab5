import Command.Command;
import Command.ConcreteCommands.*;
import Command.Invoker;
import Command.Receiver;
import Utils.ManagerOfCollection;

import java.io.BufferedReader;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        ManagerOfCollection.createMyCollection();
//        if (args[0].length() > 0) {
//            ManagerOfCollection.fillFromXml(args[0]);
//        }
//
//        Invoker commandInvoker = new Invoker();
//        HashMap<String, Command> invokerHashMap = commandInvoker.invokerHashMap;
//
//        Receiver commandReceiver = new Receiver(commandInvoker);

        // invokerHashMap.put("help", new Help(commandReceiver));
        // invokerHashMap.put("info", new Info(commandReceiver));
        // invokerHashMap.put("add", new Add(commandReceiver));
        // invokerHashMap.put("show", new Show(commandReceiver));
        // invokerHashMap.put("update", new Update(commandReceiver));
        // invokerHashMap.put("remove_by_id", new RemoveByID(commandReceiver));
        // invokerHashMap.put("clear", new Clear(commandReceiver));
        // invokerHashMap.put("exit", new Exit(commandReceiver));
        // invokerHashMap.put("remove_greater", new RemoveGreater(commandReceiver));
        // invokerHashMap.put("remove_lower", new RemoveLower(commandReceiver));
        // Чё с ней invokerHashMap.put("save", new Save(commandReceiver));
        // Делает ОЛЯ invokerHashMap.put("execute_script", new ExecuteScript(commandReceiver));
        // invokerHashMap.put("history", new History(commandReceiver));
        // invokerHashMap.put("remove_all_by_health", new RemoveAllByHealth(commandReceiver));
        // invokerHashMap.put("max_by_melee_weapon", new MaxByMeleeWeapon(commandReceiver));
        // invokerHashMap.put("print_unique_chapter", new PrintUniqueChapter(commandReceiver));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Url of database:");
        String url = scanner.nextLine();
        System.out.println("User:");
        String user = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        //redo it as reading from file

        try
        {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            connection.close();
            System.out.println("Success");
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }


//        try(Scanner scanner = new Scanner(System.in)) {
//            while (scanner.hasNextLine()) {
//                commandInvoker.invoke(scanner.nextLine().trim().split("\s+"));
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}
