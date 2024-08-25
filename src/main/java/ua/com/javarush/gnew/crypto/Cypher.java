package ua.com.javarush.gnew.crypto;

import ua.com.javarush.gnew.language.LanguageDetector;
import java.util.ArrayList;

public class Cypher {
    private StringBuilder builder = new StringBuilder();

    public String encrypt(String content, int key) {
        key = Math.negateExact(key);
        char[] contentCharArray = content.toCharArray();
        for (char currentChar : contentCharArray) {
            builder.append(ProcessSymbol.processSymbol(currentChar, key));
        }
        return builder.toString();
    }

    public String decrypt(String content, int key) {
        char[] contentCharArray = content.toCharArray();
        for (char currentChar : contentCharArray) {
            builder.append(ProcessSymbol.processSymbol(currentChar, key));
        }
        return builder.toString();
    }

    public BruteForceResult bruteforce(String content){
        ArrayList<String> wordsForBruteForce = LanguageDetector.detector(content);
        int initKey = 1;

        while (true) {
            builder.setLength(0);

            char[] contentCharArray = content.toCharArray();
            for (char currentChar : contentCharArray) {
                builder.append(ProcessSymbol.processSymbol(currentChar, initKey));
            }
            String decryptedText = builder.toString();

            for (int i = 0; i < wordsForBruteForce.size(); i++) {
                if (decryptedText.contains(wordsForBruteForce.get(i))) {
                    String key = String.valueOf(initKey);
                    return new BruteForceResult(decryptedText, key);
                }
            }
            initKey++;
        }
    }
}




