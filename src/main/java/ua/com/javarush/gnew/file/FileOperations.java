package ua.com.javarush.gnew.file;

import ua.com.javarush.gnew.cypher.Operation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {

    public String readFromFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void writeToFile(String path, String content, Operation type)  {
        try {
            switch (type){
                case ENCRYPT -> Files.write(Paths.get(modifyPath(path, "[ENCRYPTED]")), content.getBytes());
                case DECRYPT -> Files.write(Paths.get(modifyPath(path, "[DECRYPTED]")), content.getBytes());
                case BRUTE_FORCE -> Files.write(Paths.get(modifyPath(path, "[BRUTE_FORCE]")), content.getBytes());
            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    private String modifyPath(String path, String modificationType){
        int index = path.lastIndexOf(".");
        String modifiedPath = path.substring(0,index) + modificationType  + path.substring(index);
        return modifiedPath;
    }
}
