package ua.com.javarush.gnew.runner;
import java.nio.file.Path;
import java.util.HashMap;


public class ArgumentsParser {
    public RunOptions parse(String[] args) {
        Command command = null;
        Integer key = null;
        Path filePath = null;
        HashMap<String, Command> commandHashMap = new HashMap<>();
        commandHashMap.put("-e", Command.ENCRYPT);
        commandHashMap.put("-d", Command.DECRYPT);
        commandHashMap.put("-bf", Command.BRUTEFORCE);

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (commandHashMap.containsKey(arg)){
                command = commandHashMap.get(arg);
            } else if ("-f".equals(arg)){
                if (i + 1 < args.length) {
                    filePath = Path.of(args[++i]);
                } else {
                    throw new IllegalArgumentException("Missing value for file");
                }
            } else if ("-k".equals(arg) && i + 1 <args.length) {
                try {
                    key = Integer.parseInt(args[++i]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Key must be a an integer");
                }
            } else {
                throw new IllegalArgumentException("Unknown argument: " + arg);
            }
        }
        if (command == null) {
            throw new IllegalArgumentException("Command (-e, -d, or -bf) is required");
        }
        if ((command == Command.ENCRYPT || command == Command.DECRYPT) && key == null) {
            throw new IllegalArgumentException("Key is required for encrypt or decrypt mode");
        }
        if (filePath == null) {
            throw new IllegalArgumentException("File path is required");
        }

        return new RunOptions(command, key, filePath);
    }
}

