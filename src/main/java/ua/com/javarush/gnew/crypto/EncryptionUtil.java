package ua.com.javarush.gnew.crypto;

import ua.com.javarush.gnew.language.Language;

import java.util.ArrayList;

public class EncryptionUtil {

    public static String encrypt(String input, int key) {
        StringBuilder builder = new StringBuilder();
        for (char symbol : input.toCharArray()) {
            ArrayList<Character> alphabet = Language.getAlphabet(symbol);
            if (alphabet != null) {
                builder.append(newChar(alphabet, key, symbol));
            } else {
                builder.append(symbol);
            }
        }
        return builder.toString();
    }

    public static String decrypt(String input, int key) {
        return encrypt(input, -key);
    }

    public static char newChar(ArrayList<Character> alp, int key, char c) {
        int index = alp.indexOf(c);

        int sum = (index + key) % alp.size();
        if (sum < 0) {
            sum += alp.size();
        }
        return alp.get(sum);
    }
}

