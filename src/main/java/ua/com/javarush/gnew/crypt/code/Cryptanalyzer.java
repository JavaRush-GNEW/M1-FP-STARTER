package ua.com.javarush.gnew.crypt.code;

import java.util.ArrayList;
import java.util.Collections;

import static ua.com.javarush.gnew.Constants.Constants.ENG;
import static ua.com.javarush.gnew.Constants.Constants.UKR;


public class Cryptanalyzer {
    public  String encryption(String str, int key){
        key = Math.negateExact(key);
        ArrayList<Character> ENG_MOD = new ArrayList<>(ENG);
        ArrayList<Character> UKR_MOD = new ArrayList<>(UKR);
        Collections.rotate(ENG_MOD, key);
        Collections.rotate(UKR_MOD, key);
        char[] array = str.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char symbol : array) {
            int originalIndex = ENG.indexOf(symbol);
            if (originalIndex != -1) {
                Character encrypted = ENG_MOD.get(originalIndex);
                builder.append(encrypted);
                continue;
            }

            int GettingIndex = UKR.indexOf(symbol);
            if (GettingIndex != -1) {
                Character encrypted = UKR_MOD.get(GettingIndex);
                builder.append(encrypted);
            }else{
                builder.append(symbol);
            }
        }
        return builder.toString();
    }
    public String decryption(String str, int key) {
        ArrayList<Character> ENG_MOD = new ArrayList<>(ENG);
        ArrayList<Character> UKR_MOD = new ArrayList<>(UKR);
        Collections.rotate(ENG_MOD, key);
        Collections.rotate(UKR_MOD, key);
        char[] array = str.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char symbol : array) {
            int originalIndex = ENG.indexOf(symbol);
            if (originalIndex != -1) {
                Character encrypted = ENG_MOD.get(originalIndex);
                builder.append(encrypted);
                continue;
            }
            int GettingIndex = UKR.indexOf(symbol);
            if (GettingIndex != -1) {
                Character encrypted = UKR_MOD.get(GettingIndex);
                builder.append(encrypted);
            } else {
                builder.append(symbol);
            }
        }
        return builder.toString();
    }
}
