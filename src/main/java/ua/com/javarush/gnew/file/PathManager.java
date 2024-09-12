package ua.com.javarush.gnew.file;

import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.runner.RunOptions;

import java.nio.file.Path;

public class PathManager {
    public Path newFilePath(RunOptions runOptions) {
        String label = switch (runOptions.getCommand()) {
            case ENCRYPT -> " [ENCRYPTED]";
            case DECRYPT -> " [DECRYPTED]";
            case BRUTEFORCE -> " [BRUTEFORCE]";
            default -> null;
        };

        String fileName = runOptions.getFilePath().getFileName().toString();
        StringBuilder newFileName = new StringBuilder(fileName.substring(0, fileName.length() - 4));
        newFileName.append(label);
        if (label.equals(" [BRUTEFORCE]")) {
            newFileName.append(" key ").append(Cypher.key);
        }
        newFileName.append(".txt");
        return runOptions.getFilePath().resolveSibling(newFileName.toString());
    }
}
