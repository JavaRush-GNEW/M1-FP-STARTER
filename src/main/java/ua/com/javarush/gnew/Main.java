package ua.com.javarush.gnew;

import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.runner.ArgumentsParser;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

import java.nio.file.Path;

public class Main {
    //start a project
    public static void main(String[] args) {
        Cypher cypher = new Cypher();
        FileManager fileManager = new FileManager();
        ArgumentsParser argumentsParser = new ArgumentsParser();
        RunOptions runOptions = argumentsParser.parse(args);

        try {
            if (runOptions.getCommand() == Command.ENCRYPT) {
                String content = fileManager.read(runOptions.getFilePath());
                String encryptedContent = cypher.encrypt(content, runOptions.getKey());
                String fileName = runOptions.getFilePath().getFileName().toString();
                String newFileName = fileName.substring(0, fileName.length() - 4) + " [ENCRYPTED].txt";

                Path newFilePath = runOptions.getFilePath().resolveSibling(newFileName);
                fileManager.write(newFilePath, encryptedContent);
            }
            if (runOptions.getCommand() == Command.DECRYPT) {
                String content = fileManager.read(runOptions.getFilePath());
                String decryptedContent = cypher.decrypt(content, runOptions.getKey());
                String fileName = runOptions.getFilePath().getFileName().toString();
                String newFileName = fileName.substring(0, fileName.length() - 16) + " [DECRYPTED].txt";
                Path newFilePath = runOptions.getFilePath().resolveSibling(newFileName);
                fileManager.write(newFilePath, decryptedContent);
            }
            if(runOptions.getCommand()==Command.BRUTEFORCE){
                String content = fileManager.read(runOptions.getFilePath());
                String bruteForceContent= cypher.bruteForce(content);
                String fileName = runOptions.getFilePath().getFileName().toString();
                String newFileName = fileName.substring(0, fileName.length() - 16) + " [BRUTEFORCE].txt";
                Path newFilePath = runOptions.getFilePath().resolveSibling(newFileName);
                fileManager.write(newFilePath, bruteForceContent);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}