package ua.com.javarush.gnew.crypt.code;

import ua.com.javarush.gnew.Constants.Constants;

import java.util.ArrayList;
import java.util.Collections;



public class Cryptanalyzer {
    public String encryption(String str, int key) {
        Constants constants = new Constants();
        key = Math.negateExact(key);
        ArrayList<Character> ENG_LOWER_MOD = new ArrayList<>(constants.getEngLower());
        ArrayList<Character> UKR_LOWER_MOD = new ArrayList<>(constants.getUkrLower());
        Collections.rotate(ENG_LOWER_MOD, key);
        Collections.rotate(UKR_LOWER_MOD, key);

        ArrayList<Character> ENG_UPPER_MOD = new ArrayList<>(constants.getEngUpper());
        ArrayList<Character> UKR_UPPER_MOD = new ArrayList<>(constants.getUkrUpper());
        Collections.rotate(ENG_UPPER_MOD, key);
        Collections.rotate(UKR_UPPER_MOD, key);

        char[] array = str.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char symbol : array) {
            if (Character.isLowerCase(symbol)) {
                int originalIndex = constants.getEngLower().indexOf(symbol);
                if (originalIndex != -1) {
                    Character encrypted = ENG_LOWER_MOD.get(originalIndex);
                    builder.append(encrypted);
                    continue;
                }

                originalIndex = constants.getUkrLower().indexOf(symbol);
                if (originalIndex != -1) {
                    Character encrypted = UKR_LOWER_MOD.get(originalIndex);
                    builder.append(encrypted);
                } else {
                    builder.append(symbol);
                }
            }
            else if (Character.isUpperCase(symbol)) {
                int originalIndex = constants.getEngUpper().indexOf(symbol);
                if (originalIndex != -1) {
                    Character encrypted = ENG_UPPER_MOD.get(originalIndex);
                    builder.append(encrypted);
                    continue;
                }

                originalIndex = constants.getUkrUpper().indexOf(symbol);
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
        StringBuilder builder;
        builder = new StringBuilder(encryption(str, -key));
        return builder.toString();
    }

    public String getDecryption(String str, int key){
        return decryption(str,key);
    }
}
