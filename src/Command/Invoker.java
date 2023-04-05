package Command;

import BaseObjects.SpaceMarine;
import Command.ConcreteCommands.*;
import Utils.ManagerOfCollection;
import Utils.SpaceMarineCreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Invoker implements Serializable
{
    public HashMap<String, Command> invokerHashMap = new HashMap<String, Command>();
    //why is it cannot be static^^^^
    //because another commands breaks after it
    public ArrayList<String> invokerListOfCommand = new ArrayList<>();

    public void invoke(String[] command_name) throws IOException {
        try {
            if (command_name.length > 0) {
                Command command = invokerHashMap.get(command_name[0]);
                invokerListOfCommand.add(command_name[0]);
                command.execute();
            } else {
                System.out.println("You have not entered a command.");
            }
        } catch (IllegalStateException | NullPointerException ex) {
            System.out.println("There is no command " + command_name[0] + ". For reference, use – help");
        }
    }

    public Command invokeForClient(String[] command_name) throws IOException {
        fillHashMap();
        if (command_name.length > 0 && invokerHashMap.get(command_name[0]) != null) {
            Command command = invokerHashMap.get(command_name[0]);
            switch (command.getClass().getSimpleName().toString())
            {
                case "Add":
                case "RemoveGreater":
                case "RemoveLower":
                    command.setSpaceMarineFromClient(); break;
                case "Update": command.setLongFromClient(); command.setSpaceMarineFromClient(); break;
                case "RemoveAllByHealth": command.setDoubleFromClient(); break;
                case "RemoveByID": command.setLongFromClient(); break;
                case "ExecuteScript": if (command_name.length > 1)
                {
                    try
                    {
                        command.setCommandsFromScript(command_name[1]);
                    } catch (FileNotFoundException e)
                    {
                        System.out.println("There is no file with such name. Try again.");
                        return null;
                    }
                }else
                {
                    System.out.println("You have not entered a file name.");
                    return null;
                } break;
            }
            invokerListOfCommand.add(command_name[0]);
            return command;
        } else if (command_name.length == 0)
        {
            System.out.println("You have not entered a command.");
            return null;
        } else
        {
            System.out.println("There is no command " + command_name[0] + ". For reference, use – help");
            return null;
        }
    }

    public ArrayList<Command> invokeCommandFromScriptForClient(String fileName) throws FileNotFoundException
            /* Эта история пусть будет нон-статик, тогда можно будет нормально до хешмапы достучаться
            Очевидно что хочется в setCommandsFromScript дотянуться до хешмапа инвокеровского, но делать
            это вот так будто бы не очень правильно. По паттерну команда у тебя не знает об инвокере.
            В связи с этим предлагаю два решения:
            1. (мне больше нравица)
            Если мы решили команде рассказать как ей самозаполнять свои поля из файла, то будто бы мы никак не отделаемся
            от необходимости знакомить команду с другими командами. Решение как бы дублирует код, но вроде не сильно и
            вроде бы логично: хранить отдельный мап со всеми командами в этой функции. Вроде логично? Функция для
            самозаполнения всех команд из файла содержит мап всех команд. Вроед норм.
            2. (больновато, но будто правильнее)
            Сделать клиентский ресивер, который будет эту боль решать. Ресивер знает от инвокере, дотянуться до него
            может. Все команды которые проблем не вызывают, будут выглядеть коротко и лаконично, даже не лишний код.
            А вся наша клиентская логика, которую размазало по инвокеру и командам мы запихнем туда. Пока что отработаем
            концепт клиентского ресивера только на execute, потом ещё подумаем что туда вынести. Много кода из категории
            "потом перепишем и доделаем" можно запихнуть туда.


            */
    {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        String line;
        String commandLine;
        ArrayList<String> parameters = new ArrayList<>();
        ArrayList<Command> commands = new ArrayList<>();
        Invoker invoker = new Invoker();
        outer:
        while (reader.hasNextLine())
        {
            line = reader.nextLine();
            if (line.split(" ")[0].matches("add|update|remove_greater|remove_lower"))
            {
                commandLine = line;
                for (int i = 0; i < 9; i++)
                {
                    if (reader.hasNextLine())
                    {
                        line = reader.nextLine();
                        parameters.add(line);
                    }
                    else
                    {
                        System.out.println("There are not enough parameters to create an object.");
                        break outer;
                    }
                }
                SpaceMarine spaceMarine = SpaceMarineCreator.createScriptSpaceMarine(parameters);
                Command command = this.invokerHashMap.get(commandLine.split(" ")[0]);
                switch (command.getClass().getSimpleName().toString())
                {
                    case "Add":
                    case "RemoveGreater":
                    case "RemoveLower":
                        command.setSpaceMarineFromClient(spaceMarine); break;
                    case "Update": try
                    {
                        command.setLongFromClient(Long.parseLong(commandLine.split(" ")[1]));
                        command.setSpaceMarineFromClient(spaceMarine); break;
                    }catch (NumberFormatException | ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("There is no number after Update.");
                        break outer;
                    }

                    case "RemoveAllByHealth": try
                    {
                        command.setDoubleFromClient(Double.parseDouble(commandLine.split(" ")[1]));
                    }catch (NumberFormatException | ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("There is no number after Remove_All_By_Health.");
                        break outer;
                    }

                    case "RemoveByID": try
                    {
                        command.setLongFromClient(Long.parseLong(commandLine.split(" ")[1]));
                        command.setSpaceMarineFromClient(spaceMarine); break;
                    }catch (NumberFormatException | ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("There is no number after Update.");
                        break outer;
                    }

                    case "ExecuteScript": command = null; break;
                }
                commands.add(command);
            }
//            else if (line.split(" ")[0].equals("execute_script")
//                    && line.split(" ")[1].equals(ExecuteScript.getPath())) { System.out.println("An attempt to recursively call the script was stopped."); }
            else { try
            {
                commands.add(invoker.invokeForClient(line.split(" ")));
            } catch (IOException e)
            {
                System.out.println(e);
            }
            }
        }
        return commands;
    }


    private void fillHashMap()
    {
        Receiver commandReceiver = new Receiver(this);
        invokerHashMap.put("help", new Help(commandReceiver));
        invokerHashMap.put("info", new Info(commandReceiver));
        invokerHashMap.put("add", new Add(commandReceiver));
        invokerHashMap.put("show", new Show(commandReceiver));
        invokerHashMap.put("update", new Update(commandReceiver));
        invokerHashMap.put("remove_by_id", new RemoveByID(commandReceiver));
        invokerHashMap.put("clear", new Clear(commandReceiver));
        invokerHashMap.put("exit", new Exit(commandReceiver));
        invokerHashMap.put("remove_greater", new RemoveGreater(commandReceiver));
        invokerHashMap.put("remove_lower", new RemoveLower(commandReceiver));
        invokerHashMap.put("save", new Save(commandReceiver));
        invokerHashMap.put("execute_script", new ExecuteScript(commandReceiver));
        invokerHashMap.put("history", new History(commandReceiver));
        invokerHashMap.put("remove_all_by_health", new RemoveAllByHealth(commandReceiver));
        invokerHashMap.put("max_by_melee_weapon", new MaxByMeleeWeapon(commandReceiver));
        invokerHashMap.put("print_unique_chapter", new PrintUniqueChapter(commandReceiver));
    }
}
