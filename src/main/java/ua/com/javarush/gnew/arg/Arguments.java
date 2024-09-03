package ua.com.javarush.gnew.arg;

public class Arguments {
    private final String mode;
    private final String filePath;
    private final int key;

    public Arguments(String mode, String filePath, int key) {
        this.mode = mode;
        this.filePath = filePath;
        this.key = key;
    }

    public String getMode() {
        return mode;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getKey() {
        return key;
    }

    public boolean isEncryptionMode() {
        return "-e".equals(mode);
    }

    public boolean isDecryptionMode() {
        return "-d".equals(mode);
    }

    public boolean isBruteForce() {
        return "-bf".equals(mode);
    }
}

