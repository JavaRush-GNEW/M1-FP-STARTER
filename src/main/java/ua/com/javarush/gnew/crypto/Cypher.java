package ua.com.javarush.gnew.crypto;

import ua.com.javarush.gnew.language.LanguageDetector;
import java.util.ArrayList;

public class Cypher {

    public String encrypt(String content, int key) {
        StringBuilder builder = new StringBuilder();
        key = Math.negateExact(key);
        char[] contentCharArray = content.toCharArray();
        for (char currentChar : contentCharArray) {
            builder.append(ProcessSymbol.processSymbol(currentChar, key));
        }
        return builder.toString();
    }

    public String decrypt(String content, int key) {
        key = Math.negateExact(key);
        return encrypt(content, key);
    }

    public BruteForceResult bruteforce(String content){
        StringBuilder builder = new StringBuilder();
        ArrayList<String> wordsForBruteForce = LanguageDetector.detectorBF(content);
        int initKey = 1;

        while (true) {
            builder.setLength(0);
            char[] contentCharArray = content.toCharArray();
            for (char currentChar : contentCharArray) {
                builder.append(ProcessSymbol.processSymbol(currentChar, initKey));
            }
            String decryptedText = builder.toString();
            for (String s : wordsForBruteForce) {
                if (decryptedText.contains(s)) {
                    String key = String.valueOf(initKey);
                    return new BruteForceResult(decryptedText, key);
                }
            }
            initKey++;
        }
    }
}




