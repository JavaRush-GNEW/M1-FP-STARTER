package ua.com.javarush.gnew;

import ua.com.javarush.gnew.cypher.Cypher;
import ua.com.javarush.gnew.fileManager.FileManager;
import ua.com.javarush.gnew.runner.ArgumentsParser;
import ua.com.javarush.gnew.runner.RunOptions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cypher cypher = new Cypher();
        FileManager fileManager = new FileManager();
        ArgumentsParser argumentsParser = new ArgumentsParser();
        RunOptions runOptions = argumentsParser.parse(args);

        List<String> linesRead;
        List<String> linesWritten = new ArrayList<>();

        try {
            linesRead = fileManager.read(runOptions.getFilePath());
            switch (runOptions.getCommand()) {
                case ENCRYPT:
                    for (String lineRead : linesRead) {
                        linesWritten.add(cypher.encrypt(lineRead, runOptions.getKey()));
                    }
                    break;
                case DECRYPT:
                    for (String lineRead : linesRead) {
                        linesWritten.add(cypher.decrypt(lineRead, runOptions.getKey()));
                    }
                    break;
                case BRUTEFORCE:
                    for (String lineRead : linesRead) {
                        linesWritten.add(cypher.bruteForce(lineRead));
                    }
                    break;
            }

            Path resultFile = fileManager.getNewPath(runOptions.getFilePath(), runOptions.getCommand());
            if (Files.notExists(resultFile)) {
                Files.createFile(resultFile);
            }
            fileManager.write(resultFile, linesWritten);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}