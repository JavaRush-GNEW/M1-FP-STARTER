package ua.com.javarush.gnew;

import picocli.CommandLine;
import ua.com.javarush.gnew.runner.SimpleCLI;

public class Main {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new SimpleCLI()).execute(args);

    }
}
