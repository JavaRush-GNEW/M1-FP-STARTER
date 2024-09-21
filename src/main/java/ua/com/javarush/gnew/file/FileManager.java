package ua.com.javarush.gnew.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public String read(Path FilePath) throws IOException{
        return Files.readString(FilePath);
    }

    public void write(Path FilePath, String content) throws IOException{
        Files.writeString(FilePath,content);
    }
}
