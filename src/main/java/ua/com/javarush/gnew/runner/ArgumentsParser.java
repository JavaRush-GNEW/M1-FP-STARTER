package ua.com.javarush.gnew.runner;

import java.nio.file.Path;


public class ArgumentsParser {
    public RunOptions parse(String[] args) {
        Command command = null;
        Integer key = null;
        Path filePath = null;

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            if (arg.equalsIgnoreCase("-e")) {
                command = Command.ENCRYPT;
            } else if (arg.equalsIgnoreCase("-d")) {
                command = Command.DECRYPT;
            } else if (arg.equalsIgnoreCase("-bf")) {
                command = Command.BRUTEFORCE;
            } else if (arg.equalsIgnoreCase("-k")){
                if (i + 1 < args.length) {
                    key = Integer.parseInt(args[++i]);
                } else {
                    throw new IllegalArgumentException("Missing value for key");
                }
            }else if(arg.equalsIgnoreCase("-f")){
                if (i + 1 < args.length) {
                    StringBuilder filePathBuilder = new StringBuilder(args[++i]);

                    while (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                        filePathBuilder.append(" ").append(args[++i]);
                    }
                    filePath = Path.of(filePathBuilder.toString());
                } else {
                    throw new IllegalArgumentException("Missing value for file");
                }
            } else {
                throw new IllegalArgumentException("Unknown argument: " + arg);
            }
        }


        if (command == Command.ENCRYPT || command == Command.DECRYPT) {
            if (key == null) {
                throw new IllegalArgumentException("Key is required for encrypt or decrypt mode");
            }
        }

        if (filePath == null) {
            throw new IllegalArgumentException("File path is required");
        }
        return new RunOptions(command, key, filePath);
    }
}

