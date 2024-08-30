package ua.com.javarush.gnew.processing;

import java.util.HashMap;
import java.util.Map;

public class ArgumentParser {



    private final Map<String, String> arguments = new HashMap<>();
    private boolean isBruteForce = false;

    public ArgumentParser(String[] args) {
        parseArguments(args);
    }

    private void parseArguments(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-e":
                    arguments.put("mode", "encrypt");
                    break;
                case "-d":
                    arguments.put("mode", "decrypt");
                    break;
                case "-bf":
                    isBruteForce = true;
                    arguments.put("mode", "bruteforce");
                    break;
                case "-k":
                    if (i + 1 < args.length) {
                        arguments.put("key", args[++i]);
                    }
                    break;
                case "-f":
                    if (i + 1 < args.length) {
                        arguments.put("path", args[++i]);
                    }
                    break;
                default:
                    System.out.println("Unknown argument: " + args[i]);
            }
        }
    }

    public String getMode() {
        return arguments.get("mode");
    }

    public String getFilePath() {
        return arguments.get("path");
    }

    public int getKey() {
        return arguments.containsKey("key") ? Integer.parseInt(arguments.get("key")) : 0;
    }

    public boolean isBruteForce() {
        return isBruteForce;
    }
}

