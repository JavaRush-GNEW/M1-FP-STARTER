package ua.com.javarush.gnew.fileManager;

import ua.com.javarush.gnew.runner.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManager {

    public List<String> read(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public void write (Path path, List<String> lines) throws IOException {
        Files.write(path, lines);
    }

    public String getNewPath(String path, Command command) {
        String markerOfAction = switch (command) {
            case DECRYPT:
                yield " [DECRYPTED].txt";
            case ENCRYPT:
                yield " [ENCRYPTED].txt";
            default:
                yield ".txt";
        };
        return path.substring(0, path.length() - 4) + markerOfAction;
    }
}