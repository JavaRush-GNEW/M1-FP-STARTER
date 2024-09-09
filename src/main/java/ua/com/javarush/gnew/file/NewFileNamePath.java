package ua.com.javarush.gnew.file;

import ua.com.javarush.gnew.runner.RunOptions;
import java.nio.file.Path;

public class NewFileNamePath {

    public Path newPath(RunOptions runOptions) {
        FileNameTag tag = new FileNameTag();
        return Path.of(tag.fileNameTag(runOptions));
    }
}
