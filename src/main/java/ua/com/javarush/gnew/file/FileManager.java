package ua.com.javarush.gnew.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public static void write(String filePath, String content) throws IOException {
        Files.write(Path.of(filePath), content.getBytes());
    }

    public static String read(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }
}

