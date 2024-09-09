package ua.com.javarush.gnew.file;

import ua.com.javarush.gnew.crypto.KeyManager;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

public class FileNameTag {

        protected String fileNameNotExtension(RunOptions runOptions){
           String fileName = runOptions.getFilePath().getFileName().toString();
           int lastDotIndex = fileName.lastIndexOf('.');
           return fileName.substring(0, lastDotIndex);
        }

        protected String nameTag(RunOptions runOptions){
            StringBuilder tag = new StringBuilder();
            if(runOptions.getCommand() == Command.ENCRYPT){
                tag.append("[ENCRYPTED]");
            } else if (runOptions.getCommand() == Command.DECRYPT) {
                tag.append("[DECRYPTED]");
            } else if (runOptions.getCommand() == Command.BRUTEFORCE) {
                tag.append("[DECRYPTED] [WITH KEY ");
                KeyManager keyManager = new KeyManager();
                tag.append(keyManager.getKey(runOptions));
                tag.append("]");
            }
            return tag.toString();
        }

        protected String fileNameTag(RunOptions runOptions){
             StringBuilder sb = new StringBuilder();
             sb.append(fileNameNotExtension(runOptions));
             sb.append(nameTag(runOptions));
            return sb.toString() + ".txt";

        }


}
