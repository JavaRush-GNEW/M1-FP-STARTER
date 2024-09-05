package ua.com.javarush.gnew.fileManager;

import ua.com.javarush.gnew.runner.Command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManager {

    public List<String> read(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public void write(Path path, List<String> lines) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()))) {
            for (int i = 0; i < lines.size(); i++) {
                writer.write(lines.get(i));
                if (i < lines.size() - 1) {
                    writer.newLine();
                }
            }
        }
    }

    public Path getNewPath(Path path, Command command) {

        String markerOfAction = switch (command) {
            case DECRYPT:
                yield " [DECRYPTED].txt";
            case ENCRYPT:
                yield " [ENCRYPTED].txt";
            default:
                yield ".txt";
        };

        String originalPath = path.toString();
        String newPath = originalPath.substring(0, originalPath.length() - 4) + markerOfAction;
        return Path.of(newPath);
    }

    public Path getNewPath(Path path, int key) {
        String originalPath = path.toString();
        String newPath = originalPath.substring(0, originalPath.length() - 4) + " [BRUTE_FORCE] " + key + ".txt";
        return Path.of(newPath);
    }
}