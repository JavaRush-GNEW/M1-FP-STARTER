package ua.com.javarush.gnew.crypt.code;

import java.util.ArrayList;
import java.util.Collections;

import static ua.com.javarush.gnew.Constants.Constants.ENG;
import static ua.com.javarush.gnew.Constants.Constants.UKR;

public class RunBruteforce {

    public String bruteforce(String str, String[] dictionary, String[] dictionaryUKR) {
        char[] array = str.toCharArray();
        String bestMatch = null;
        int maxMatches = 0;

        for (int key = 0; key < ENG.size(); key++) {
            ArrayList<Character> ENG_MOD = new ArrayList<>(ENG);
            Collections.rotate(ENG_MOD, key);
            StringBuilder builder = new StringBuilder();

            for (char symbol : array) {
                int originalIndex = ENG.indexOf(symbol);
                if (originalIndex != -1) {
                    Character decrypted = ENG_MOD.get(originalIndex);
                    builder.append(decrypted);
                } else {
                    builder.append(symbol);
                }
            }

            String DecryptedText = builder.toString();
            int matches = countMatches(DecryptedText, dictionary);

            if (matches > maxMatches) {
                maxMatches = matches;
                bestMatch = DecryptedText;
            }
        }


        for (int key = 0; key < UKR.size(); key++) {
            ArrayList<Character> UKR_MOD = new ArrayList<>(UKR);
            Collections.rotate(UKR_MOD, key);
            StringBuilder builder = new StringBuilder();

            for (char symbol : array) {
                int originalIndex = UKR.indexOf(symbol);
                if (originalIndex != -1) {
                    Character decrypted = UKR_MOD.get(originalIndex);
                    builder.append(decrypted);
                } else {
                    builder.append(symbol);
                }
            }

            String DecryptedText = builder.toString();
            int matches = countMatches(DecryptedText, dictionaryUKR);

            if (matches > maxMatches) {
                maxMatches = matches;
                bestMatch = DecryptedText;
            }
        }

        return bestMatch != null ? bestMatch : "Брутфорс не дал результатов.";
    }


    public String getKey(String str, String[] dictionary, String[] dictionaryUKR) {
        char[] array = str.toCharArray();
        int maxMatches = 0;
        String KeyResult = null;

        for (int key = 0; key < ENG.size(); key++) {
            ArrayList<Character> ENG_MOD = new ArrayList<>(ENG);
            Collections.rotate(ENG_MOD, key);
            StringBuilder builder = new StringBuilder();

            for (char symbol : array) {
                int originalIndex = ENG.indexOf(symbol);
                if (originalIndex != -1) {
                    Character decrypted = ENG_MOD.get(originalIndex);
                    builder.append(decrypted);
                } else {
                    builder.append(symbol);
                }
            }

            String DecryptedText = builder.toString();
            int matches = countMatches(DecryptedText, dictionary);

            if (matches > maxMatches) {
                maxMatches = matches;
                KeyResult = "Key: " + key + " (ENG)";
            }
        }


        for (int key = 0; key < UKR.size(); key++) {
            ArrayList<Character> UKR_MOD = new ArrayList<>(UKR);
            Collections.rotate(UKR_MOD, key);
            StringBuilder builder = new StringBuilder();

            for (char symbol : array) {
                int originalIndex = UKR.indexOf(symbol);
                if (originalIndex != -1) {
                    Character decrypted = UKR_MOD.get(originalIndex);
                    builder.append(decrypted);
                } else {
                    builder.append(symbol);
                }
            }

            String DecryptedText = builder.toString();
            int matches = countMatches(DecryptedText, dictionaryUKR);

            if (matches > maxMatches) {
                maxMatches = matches;
                KeyResult = "Key: " + key + " (UKR)";
            }
        }

        return KeyResult;
    }


    private int countMatches(String text, String[] dictionary) {
        int matches = 0;
        for (String word : dictionary) {
            if (text.contains(word)) {
                matches++;
            }
        }
        return matches;
    }
}
