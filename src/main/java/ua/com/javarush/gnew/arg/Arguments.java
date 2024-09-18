package ua.com.javarush.gnew.arg;

public class Arguments {
    private final String mode;
    private final String filePath;
    private final int key;
    private final String frequencyAnalysisFilePath;

    public Arguments(String mode, String filePath, int key, String frequencyAnalysisFilePath) {
        this.mode = mode;
        this.filePath = filePath;
        this.key = key;
        this.frequencyAnalysisFilePath = frequencyAnalysisFilePath;
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
    public String getFrequencyAnalysisFilePath() {
        return frequencyAnalysisFilePath;
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
    public boolean hasFrequencyAnalysisFile() {
        return frequencyAnalysisFilePath != null;
    }
}

