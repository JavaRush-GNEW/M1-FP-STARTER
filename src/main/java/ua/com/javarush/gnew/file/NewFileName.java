package ua.com.javarush.gnew.file;

public class NewFileName {
    public static String getNewFileName(String file, String suffix) {
        int dotIndex = file.lastIndexOf('.');
        if (dotIndex == -1) {
            return file + suffix + ".txt";
        } else {
            return file.substring(0, dotIndex) + suffix + file.substring(dotIndex);
        }
    }
}
