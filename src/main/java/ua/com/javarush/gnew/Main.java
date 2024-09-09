package ua.com.javarush.gnew;

import ua.com.javarush.gnew.crypto.Cryptor;
import ua.com.javarush.gnew.crypto.KeyManager;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.file.NewFileNamePath;
import ua.com.javarush.gnew.runner.ArgumentsParser;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        ArgumentsParser argumentsParser = new ArgumentsParser();
        RunOptions runOptions = argumentsParser.parse(args);
        KeyManager keyManager = new KeyManager();

        try {
            String content = fileManager.read(runOptions.getFilePath());
            Cryptor cryptor;
            if(runOptions.getCommand() == Command.ENCRYPT || runOptions.getCommand() == Command.DECRYPT){
                int key = keyManager.getKey(runOptions);
                cryptor = new Cryptor(content, key);
                String cryptoContent = cryptor.cypher();
                NewFileNamePath path = new NewFileNamePath();
                fileManager.write(path.newPath(runOptions) , cryptoContent);
            } else if (runOptions.getCommand() == Command.BRUTEFORCE) {
                cryptor = new Cryptor(content, keyManager.keySelection(runOptions));
                String cryptoContent = cryptor.cypher();
                NewFileNamePath path = new NewFileNamePath();
                fileManager.write(path.newPath(runOptions) , cryptoContent);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}