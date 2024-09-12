package ua.com.javarush.gnew.file;

import ua.com.javarush.gnew.runner.RunOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public String read(Path filePath) {
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(Path filePath, String content) {
        try {
            Files.writeString(filePath, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
