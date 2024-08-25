package ua.com.javarush.gnew.crypto;

public class BruteForceResult {
    private String key;
    private String decryptedContent;

    public BruteForceResult(String decryptedContent, String key) {
        this.decryptedContent = decryptedContent;
        this.key = key;
    }

    public String getDecryptedContent() {
        return decryptedContent;
    }

    public String getKey() {
        return key;
    }
}
