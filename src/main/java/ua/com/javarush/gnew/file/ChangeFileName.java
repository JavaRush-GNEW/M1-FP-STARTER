package ua.com.javarush.gnew.file;

import ua.com.javarush.gnew.runner.RunOptions;

import java.nio.file.Path;

public class ChangeFileName {

    public Path newFileName (RunOptions runOptions, String fileNameEnds){
        String fileName = runOptions.getFilePath().getFileName().toString();
        String newFileName = fileName.substring(0, fileName.length() - 4) + " ["+ fileNameEnds +"].txt";
        return runOptions.getFilePath().resolveSibling(newFileName);
    }

    public Path newFileNameWithKey (RunOptions runOptions, String fileNameEnds, String key ){
        String fileName = runOptions.getFilePath().getFileName().toString();
        String newFileName = fileName.substring(0, fileName.length() - 4) + " ["+ fileNameEnds +"] Key " + key +".txt";
        return runOptions.getFilePath().resolveSibling(newFileName);
    }
}
