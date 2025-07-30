package ua.com.javarush.gnew.crypto;

import ua.com.javarush.gnew.language.Language;
import ua.com.javarush.gnew.service.TextAnalyzer;

public class Cypher {
    private static final TextAnalyzer TEXT_ANALYZER = new TextAnalyzer();
    private final Language language;

    public Cypher(Language language) {
        this.language = language;
    }

    public String encrypt(String text, int key) {
        return shiftText(text, key);
    }

    public String decrypt(String text, int key) {
        return shiftText(text, -key);
    }

    private String shiftText(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char symbol : text.toCharArray()) {
            if (language.contains(symbol)) {
                int index = language.indexOf(symbol);
                int shiftedIndex = (index + key + language.size()) % language.size();
                result.append(language.get(shiftedIndex));
            } else {
                result.append(symbol);
            }
        }
        return result.toString();
    }

    public String bruteForce(String encryptedText) {
        String bestGuess = "";
        int bestScore = Integer.MIN_VALUE;
        for (int key = 1; key < language.size(); key++) {
            String decrypted = decrypt(encryptedText, key);
            int score = TEXT_ANALYZER.evaluate(decrypted);
            if (score > bestScore) {
                bestScore = score;
                bestGuess = decrypted;
            }
        }
        return bestGuess;
    }
}
