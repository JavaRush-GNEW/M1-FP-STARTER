package ua.com.javarush.gnew.runner;

import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.language.Language;
import ua.com.javarush.gnew.service.ArgumentsParser;
import ua.com.javarush.gnew.service.LanguageDetector;

import java.nio.file.Path;
import java.util.Scanner;

public class AppRunner {
    private final ArgumentsParser argumentsParser = new ArgumentsParser();
    private final FileManager fileManager = new FileManager();
    private final LanguageDetector detector = new LanguageDetector();


    public void run(String[] args) {
        if (args.length == 0) {
            args = getArgsFromScanner();
        }

        RunOptions runOptions = argumentsParser.parse(args);
        String newFilePath = runWithOptions(runOptions);

        System.out.println("File saved to: " + newFilePath);
    }

    private String generateNewFileName(RunOptions runOptions) {
        String fileName = runOptions.getFilePath().getFileName().toString();
        String suffix = runOptions.getCommand() == Command.ENCRYPT ? "[ENCRYPTED]" : "[DECRYPTED]";
        String baseName = fileName.substring(0, fileName.length() - 4);
        return baseName + " " + suffix + ".txt";
    }

    private String[] getArgsFromScanner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter command (ENCRYPT / DECRYPT / BRUTE_FORCE):");
        String commandInput = scanner.nextLine().trim().toUpperCase();

        System.out.println("Enter path to file:");
        String filePath = scanner.nextLine().trim();

        if ("BRUTE_FORCE".equals(commandInput)) {
            return new String[]{"-bf", "-f", filePath};
        }

        System.out.println("Enter key :");
        String keyInput = scanner.nextLine().trim();

        return switch (commandInput) {
            case "ENCRYPT" -> new String[]{"-e", "-k", keyInput, "-f", filePath};
            case "DECRYPT" -> new String[]{"-d", "-k", keyInput, "-f", filePath};
            default -> throw new IllegalArgumentException("Unsupported command: " + commandInput);
        };

    }

    public String runWithOptions(RunOptions runOptions) {
        String content = fileManager.read(runOptions.getFilePath());
        Language detectedLanguage = detector.detect(content);
        Cypher cypher = new Cypher(detectedLanguage);

        String processedContent;
        if (runOptions.getCommand() == Command.ENCRYPT) {
            processedContent = cypher.encrypt(content, runOptions.getKey());
        } else if (runOptions.getCommand() == Command.DECRYPT) {
            processedContent = cypher.decrypt(content, runOptions.getKey());
        } else {
            processedContent = cypher.bruteForce(content);
        }

        String newFileName = generateNewFileName(runOptions);
        Path newFilePath = runOptions.getFilePath().resolveSibling(newFileName);
        fileManager.write(newFilePath, processedContent);
        return newFileName;
    }

}
