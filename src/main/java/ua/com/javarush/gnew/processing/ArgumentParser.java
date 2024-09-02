package ua.com.javarush.gnew.processing;

import ua.com.javarush.gnew.cypher.Operation;

import java.util.HashMap;
import java.util.Map;

public class ArgumentParser {
    
    private boolean isBruteForce = false;
    private Operation mode;
    private String path;
    private String key;

    public ArgumentParser(String[] args) {
        parseArguments(args);
    }

    private void parseArguments(String[] args) {
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-e":
                    this.mode = Operation.ENCRYPT;
                    break;
                case "-d":
                    this.mode = Operation.DECRYPT;
                    break;
                case "-bf":
                    isBruteForce = true;
                    this.mode = Operation.BRUTE_FORCE;
                    break;
                case "-k":
                    if (i + 1 < args.length) {
                        this.key = args[++i];
                    }
                    break;
                case "-f":
                    if (i + 1 < args.length) {
                        this.path = args[++i];
                    }
                    break;
                default:
                    System.out.println("Unknown argument: " + args[i]);
            }
        }
    }

    public Operation getMode() {
        return mode;
    }

    public String getFilePath() {
        return path;
    }

    public int getKey() {
        return key!= null ? Integer.parseInt((key)) : 0;
    }

    public boolean isBruteForce() {
        return isBruteForce;
    }
}

