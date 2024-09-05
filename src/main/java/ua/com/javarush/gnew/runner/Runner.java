package ua.com.javarush.gnew.runner;

import ua.com.javarush.gnew.arg.ArgumentParser;
import ua.com.javarush.gnew.arg.Arguments;
import ua.com.javarush.gnew.bruteForce.BruteForce;
import ua.com.javarush.gnew.crypto.EncryptionUtil;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.file.NewFileName;

import java.util.Scanner;

public class Runner {
    private static Runner runner;
    private Runner(){}
    public static Runner getRunner(){
        if (runner == null){
            runner = new Runner();
        }
        return runner;
    }
    public void run(String[] args){
        try {
            Arguments arguments = ArgumentParser.parse(args);

            String content = FileManager.read(arguments.getFilePath());
            String result;
            String newFile;

            EncryptionUtil encryptionUtil = new EncryptionUtil();
            if (arguments.isEncryptionMode()) {
                result = encryptionUtil.encrypt(content, arguments.getKey());
                newFile = NewFileName.getNewFileName(arguments.getFilePath(), "[ENCRYPTED]");
            } else if (arguments.isDecryptionMode()) {
                result = encryptionUtil.decrypt(content, arguments.getKey());
                newFile = NewFileName.getNewFileName(arguments.getFilePath(), "[DECRYPTED]");
            } else if (arguments.isBruteForce()) {
                int key = new BruteForce().brute_force(content);
                result = encryptionUtil.decrypt(content, key);
                newFile = NewFileName.getNewFileName(arguments.getFilePath(), "[DECRYPTED]");
                System.out.println("Key found using brute force: " + key);
            } else {
                throw new IllegalArgumentException("Invalid mode. Use '-e' for encryption, '-d' for decryption, or '-bf' for brute force.");
            }

            FileManager.write(newFile, result);
            System.out.println("Operation completed successfully. Output file: " + newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void runWithConsol(){
        try(Scanner scanner = new Scanner(System.in)) {
            String string = "";
            while (!"exit".equals(string)) {
                System.out.print("Enter command or 'exit' to quit: ");
                string = scanner.nextLine();
                if ("exit".equalsIgnoreCase(string)) {
                    break;
                }
                String[] strings = string.split(" ");
                run(strings);
            }
        }
    }
}
