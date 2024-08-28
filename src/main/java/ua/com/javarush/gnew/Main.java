package ua.com.javarush.gnew;

import ua.com.javarush.gnew.crypto.BruteForceResult;
import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.file.ChangeFileName;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.runner.ArgumentsParser;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

import java.nio.file.Path;

public class Main {

    public static Cypher cypher = new Cypher();
    public static FileManager fileManager = new FileManager();
    public static ArgumentsParser argumentsParser = new ArgumentsParser();
    public static ChangeFileName changeFileName = new ChangeFileName();

    public static void main(String[] args) {
        RunOptions runOptions = argumentsParser.parse(args);
        String content = fileManager.read(runOptions.getFilePath());

        try {
            if (runOptions.getCommand() == Command.ENCRYPT) {

                Path newFilePath = changeFileName.newFileName(runOptions, "ENCRYPTED");
                fileManager.write(newFilePath, cypher.encrypt(content, runOptions.getKey()));
            } else if (runOptions.getCommand() == Command.DECRYPT) {

                Path newFilePath = changeFileName.newFileName(runOptions, "DECRYPTED");
                fileManager.write(newFilePath, cypher.decrypt(content, runOptions.getKey()));
            } else if (runOptions.getCommand() == Command.BRUTEFORCE) {

                BruteForceResult result = cypher.bruteforce(content);
                Path newFilePath = changeFileName.newFileNameWithKey(runOptions, "DECRYPTED", result.getKey());
                fileManager.write(newFilePath, result.getDecryptedContent());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}