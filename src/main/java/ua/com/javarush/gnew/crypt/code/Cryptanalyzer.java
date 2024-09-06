package ua.com.javarush.gnew.crypt.code;

import java.util.ArrayList;
import java.util.Collections;

import static ua.com.javarush.gnew.Constants.Constants.*;


public class Cryptanalyzer {
    public String encryption(String str, int key) {
        key = Math.negateExact(key);
        ArrayList<Character> ENG_LOWER_MOD = new ArrayList<>(ENG_LOWER);
        ArrayList<Character> UKR_LOWER_MOD = new ArrayList<>(UKR_LOWER);
        Collections.rotate(ENG_LOWER_MOD, key);
        Collections.rotate(UKR_LOWER_MOD, key);

        ArrayList<Character> ENG_UPPER_MOD = new ArrayList<>(ENG_UPPER);
        ArrayList<Character> UKR_UPPER_MOD = new ArrayList<>(UKR_UPPER);
        Collections.rotate(ENG_UPPER_MOD, key);
        Collections.rotate(UKR_UPPER_MOD, key);

        char[] array = str.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char symbol : array) {
            if (Character.isLowerCase(symbol)) {
                int originalIndex = ENG_LOWER.indexOf(symbol);
                if (originalIndex != -1) {
                    Character encrypted = ENG_LOWER_MOD.get(originalIndex);
                    builder.append(encrypted);
                    continue;
                }

                originalIndex = UKR_LOWER.indexOf(symbol);
                if (originalIndex != -1) {
                    Character encrypted = UKR_LOWER_MOD.get(originalIndex);
                    builder.append(encrypted);
                } else {
                    builder.append(symbol);
                }
            }
            else if (Character.isUpperCase(symbol)) {
                int originalIndex = ENG_UPPER.indexOf(symbol);
                if (originalIndex != -1) {
                    Character encrypted = ENG_UPPER_MOD.get(originalIndex);
                    builder.append(encrypted);
                    continue;
                }

                originalIndex = UKR_UPPER.indexOf(symbol);
                if (originalIndex != -1) {
                    Character encrypted = UKR_UPPER_MOD.get(originalIndex);
                    builder.append(encrypted);
                } else {
                    builder.append(symbol);
                }
            } else {
                builder.append(symbol);
            }
        }
        return builder.toString();
    }

    public String decryption(String str, int key) {
        ArrayList<Character> ENG_LOWER_MOD = new ArrayList<>(ENG_LOWER);
        ArrayList<Character> UKR_LOWER_MOD = new ArrayList<>(UKR_LOWER);
        Collections.rotate(ENG_LOWER_MOD, key);
        Collections.rotate(UKR_LOWER_MOD, key);

        ArrayList<Character> ENG_UPPER_MOD = new ArrayList<>(ENG_UPPER);
        ArrayList<Character> UKR_UPPER_MOD = new ArrayList<>(UKR_UPPER);
        Collections.rotate(ENG_UPPER_MOD, key);
        Collections.rotate(UKR_UPPER_MOD, key);

        char[] array = str.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char symbol : array) {
            if (Character.isLowerCase(symbol)) {
                int originalIndex = ENG_LOWER.indexOf(symbol);
                if (originalIndex != -1) {
                    Character decrypted = ENG_LOWER_MOD.get(originalIndex);
                    builder.append(decrypted);
                    continue;
                }

                originalIndex = UKR_LOWER.indexOf(symbol);
                if (originalIndex != -1) {
                    Character decrypted = UKR_LOWER_MOD.get(originalIndex);
                    builder.append(decrypted);
                } else {
                    builder.append(symbol);
                }
            }
            else if (Character.isUpperCase(symbol)) {
                int originalIndex = ENG_UPPER.indexOf(symbol);
                if (originalIndex != -1) {
                    Character decrypted = ENG_UPPER_MOD.get(originalIndex);
                    builder.append(decrypted);
                    continue;
                }

                originalIndex = UKR_UPPER.indexOf(symbol);
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
        return builder.toString();
    }
}
