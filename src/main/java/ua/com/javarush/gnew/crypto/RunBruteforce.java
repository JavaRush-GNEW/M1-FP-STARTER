package ua.com.javarush.gnew.crypto;

import java.util.ArrayList;
import java.util.Collections;

import static ua.com.javarush.gnew.Constants.Constants.ENG;

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
                        Character encrypted = ENG_MOD.get(originalIndex);
                        builder.append(encrypted);
                    } else {
                        builder.append(symbol);
                    }
                }
                String DecryptedText = builder.toString();
                int matches = 0;
                for (String words : dictionary) {
                    if (DecryptedText.contains(words)) {
                        matches++;
                    }
                }
                //System.out.println("Key: " + key + " DecryptedText: " + DecryptedText + " Matches: " + matches);
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
                        Character encrypted = ENG_MOD.get(originalIndex);
                        builder.append(encrypted);
                    } else {
                        builder.append(symbol);
                    }
                }
                String DecryptedText = builder.toString();
                int matches = 0;
                for (String words : dictionary) {
                    if (DecryptedText.contains(words)) {
                        matches++;
                    }
                }
                //System.out.println("Key: " + key + " DecryptedText: " + DecryptedText + " Matches: " + matches);

                if (matches > maxMatches) {
                    maxMatches = matches;
                    KeyResult = "Key: " + key;
                }
            }
            return KeyResult;
        }
    }

