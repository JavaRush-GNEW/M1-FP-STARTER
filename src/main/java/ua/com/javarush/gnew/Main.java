package ua.com.javarush.gnew;



import ua.com.javarush.gnew.crypt.code.Cryptanalyzer;
import ua.com.javarush.gnew.crypt.code.RunBruteforce;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.runner.ArgumentsParser;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

import java.nio.file.Path;

import static ua.com.javarush.gnew.Dictionary.Dictionary.dictionary;
import static ua.com.javarush.gnew.Dictionary.Dictionary.dictionaryUKR;

public class Main {
    public static void main(String[] args) {
        Cryptanalyzer cryptanalyzer = new Cryptanalyzer();
        RunBruteforce runBruteforce = new RunBruteforce();
        FileManager fileManager = new FileManager();
        ArgumentsParser argumentsParser = new ArgumentsParser();
        RunOptions runOptions = argumentsParser.parse();
        try {
            if (runOptions.getCommand() == Command.ENCRYPT) {
                String content = fileManager.read(runOptions.getFilePath());
                String encryptedContent = cryptanalyzer.encryption(content, runOptions.getKey());
                String fileName = runOptions.getFilePath().getFileName().toString();
                String newFileName = fileName.substring(0, fileName.length() - 4) + " [ENCRYPTED].txt";

                Path newFilePath = runOptions.getFilePath().resolveSibling(newFileName);
                fileManager.write(newFilePath, encryptedContent);
            } else if (runOptions.getCommand() == Command.DECRYPT) {
                String content = fileManager.read(runOptions.getFilePath());
                String encryptedContent = cryptanalyzer.decryption(content, runOptions.getKey());
                String fileName = runOptions.getFilePath().getFileName().toString();
                String newFileName = fileName.substring(0, fileName.length() - 4) + " [DECRYPTED].txt";

                Path newFilePath = runOptions.getFilePath().resolveSibling(newFileName);
                fileManager.write(newFilePath, encryptedContent);
            } else if (runOptions.getCommand() == Command.BRUTEFORCE) {
                String content = fileManager.read(runOptions.getFilePath());
                String encryptedContent = runBruteforce.bruteforce(content,dictionary, dictionaryUKR);
                String fileName = runOptions.getFilePath().getFileName().toString();
                String key = runBruteforce.getKey(content, dictionary, dictionaryUKR).replace("Key: ", "");
                String newFileName = fileName.substring(0, fileName.length() - 4) + " [DECRYPTED Key -" + key+ "].txt";

                Path newFilePath = runOptions.getFilePath().resolveSibling(newFileName);
                fileManager.write(newFilePath, encryptedContent);
            }
        }catch (Exception e){
            System.out.println("Smth went wrong");
        }
    }
}
