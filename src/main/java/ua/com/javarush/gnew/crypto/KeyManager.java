package ua.com.javarush.gnew.crypto;

import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.runner.RunOptions;
import ua.com.javarush.gnew.runner.Command;


public class KeyManager {

    public int getKey(RunOptions runOptions){
        if (runOptions.getCommand() == Command.ENCRYPT) {
            return (runOptions.getKey() % 26) * -1;
        }else if (runOptions.getCommand() == Command.DECRYPT) {
            return  runOptions.getKey() % 26;
        } else if (runOptions.getCommand() == Command.BRUTEFORCE) {
            return keySelection(runOptions);
        }else {
            return 0;
        }
    }

    public int keySelection(RunOptions runOptions) {
        FileManager fileManager = new FileManager();
        String input =fileManager.read(runOptions.getFilePath());
        Cryptor cryptor = new Cryptor(input);
        return ConstantsForCryptor.PUNCTUATION.getCharsArrayConstant().indexOf(cryptor.MostFrequentChar());
    }

}
