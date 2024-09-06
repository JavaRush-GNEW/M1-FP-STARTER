package ua.com.javarush.gnew.crypt.code;

import java.util.ArrayList;
import java.util.Collections;

import static ua.com.javarush.gnew.Constants.Constants.*;

public class RunBruteforce {
    public String bruteforce(String str, String[] dictionary, String[] dictionaryUKR) {
        char[] array = str.toCharArray();
        String bestMatch = null;
        int maxMatches = 0;

        for (int key = 0; key < ENG_LOWER.size(); key++) {

            ArrayList<Character> ENG_LOWER_MOD = new ArrayList<>(ENG_LOWER);
            Collections.rotate(ENG_LOWER_MOD, key);
            ArrayList<Character> ENG_UPPER_MOD = new ArrayList<>(ENG_UPPER);
            Collections.rotate(ENG_UPPER_MOD, key);

            StringBuilder builder = new StringBuilder();

            for (char symbol : array) {
                if (Character.isLowerCase(symbol)) {
                    int originalIndex = ENG_LOWER.indexOf(symbol);
                    if (originalIndex != -1) {
                        Character decrypted = ENG_LOWER_MOD.get(originalIndex);
                        builder.append(decrypted);
                    } else {
                        builder.append(symbol);
                    }
                } else if (Character.isUpperCase(symbol)) {
                    int originalIndex = ENG_UPPER.indexOf(symbol);
                    if (originalIndex != -1) {
                        Character decrypted = ENG_UPPER_MOD.get(originalIndex);
                        builder.append(decrypted);
                    } else {
                        builder.append(symbol);
                    }
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
        for (int key = 0; key < UKR_LOWER.size(); key++) {

            ArrayList<Character> UKR_LOWER_MOD = new ArrayList<>(UKR_LOWER);
            Collections.rotate(UKR_LOWER_MOD, key);

            ArrayList<Character> UKR_UPPER_MOD = new ArrayList<>(UKR_UPPER);
            Collections.rotate(UKR_UPPER_MOD, key);

            StringBuilder builder = new StringBuilder();

            for (char symbol : array) {
                if (Character.isLowerCase(symbol)) {
                    int originalIndex = UKR_LOWER.indexOf(symbol);
                    if (originalIndex != -1) {
                        Character decrypted = UKR_LOWER_MOD.get(originalIndex);
                        builder.append(decrypted);
                    } else {
                        builder.append(symbol);
                    }
                } else if (Character.isUpperCase(symbol)) {
                    int originalIndex = UKR_UPPER.indexOf(symbol);
                    if (originalIndex != -1) {
                        Character decrypted = UKR_UPPER_MOD.get(originalIndex);
                        builder.append(decrypted);
                    } else {
                        builder.append(symbol);
                    }
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

        for (int key = 0; key < ENG_LOWER.size(); key++) {
            ArrayList<Character> ENG_LOWER_MOD = new ArrayList<>(ENG_LOWER);
            Collections.rotate(ENG_LOWER_MOD, key);

            ArrayList<Character> ENG_UPPER_MOD = new ArrayList<>(ENG_UPPER);
            Collections.rotate(ENG_UPPER_MOD, key);

            StringBuilder builder = new StringBuilder();

            for (char symbol : array) {
                if (Character.isLowerCase(symbol)) {
                    int originalIndex = ENG_LOWER.indexOf(symbol);
                    if (originalIndex != -1) {
                        Character decrypted = ENG_LOWER_MOD.get(originalIndex);
                        builder.append(decrypted);
                    } else {
                        builder.append(symbol);
                    }
                } else if (Character.isUpperCase(symbol)) {
                    int originalIndex = ENG_UPPER.indexOf(symbol);
                    if (originalIndex != -1) {
                        Character decrypted = ENG_UPPER_MOD.get(originalIndex);
                        builder.append(decrypted);
                    } else {
                        builder.append(symbol);
                    }
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

        for (int key = 0; key < UKR_LOWER.size(); key++) {
            ArrayList<Character> UKR_LOWER_MOD = new ArrayList<>(UKR_LOWER);
            Collections.rotate(UKR_LOWER_MOD, key);

            ArrayList<Character> UKR_UPPER_MOD = new ArrayList<>(UKR_UPPER);
            Collections.rotate(UKR_UPPER_MOD, key);

            StringBuilder builder = new StringBuilder();

            for (char symbol : array) {
                if (Character.isLowerCase(symbol)) {
                    int originalIndex = UKR_LOWER.indexOf(symbol);
                    if (originalIndex != -1) {
                        Character decrypted = UKR_LOWER_MOD.get(originalIndex);
                        builder.append(decrypted);
                    } else {
                        builder.append(symbol);
                    }
                } else if (Character.isUpperCase(symbol)) {
                    int originalIndex = UKR_UPPER.indexOf(symbol);
                    if (originalIndex != -1) {
                        Character decrypted = UKR_UPPER_MOD.get(originalIndex);
                        builder.append(decrypted);
                    } else {
                        builder.append(symbol);
                    }
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

