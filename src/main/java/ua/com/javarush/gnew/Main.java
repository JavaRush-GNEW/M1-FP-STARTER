package ua.com.javarush.gnew;

import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.file.PathManager;
import ua.com.javarush.gnew.runner.ArgumentsParser;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;


public class Main {
    //start a project
    public static void main(String[] args) {
        Cypher cypher = new Cypher();
        FileManager fileManager = new FileManager();
        ArgumentsParser argumentsParser = new ArgumentsParser();
        RunOptions runOptions = argumentsParser.parse(args);
        PathManager pathManager = new PathManager();

        try {
            if (runOptions.getCommand() == Command.ENCRYPT) {
                String content = fileManager.read(runOptions.getFilePath());
                String encryptedContent = cypher.encrypt(content, runOptions.getKey());
                fileManager.write(pathManager.newFilePath(runOptions), encryptedContent);
            }
            if (runOptions.getCommand() == Command.DECRYPT) {
                String content = fileManager.read(runOptions.getFilePath());
                String decryptedContent = cypher.decrypt(content, runOptions.getKey());
                fileManager.write(pathManager.newFilePath(runOptions), decryptedContent);
            }
            if (runOptions.getCommand() == Command.BRUTEFORCE) {
                String content = fileManager.read(runOptions.getFilePath());
                String bruteForceContent = cypher.bruteForce(content);
                fileManager.write(pathManager.newFilePath(runOptions), bruteForceContent);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}