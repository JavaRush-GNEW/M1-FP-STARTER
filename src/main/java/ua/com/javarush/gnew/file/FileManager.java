package ua.com.javarush.gnew.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public String read(Path filePath) {
        String content = null;
        try {
            content = Files.readString(filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return content;
    }

    public void write(Path filePath, String content) {
        try {
            Files.writeString(filePath, content);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
