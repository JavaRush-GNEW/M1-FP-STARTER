package ua.com.javarush.gnew.language;

import java.util.ArrayList;

public class LanguageDetector {

    public static ArrayList<Character> detector (char content) {

        if (Character.isLowerCase(content)){
            if (Language.ALPHABET_ENG.contains(content)) {
                return Language.ALPHABET_ENG;
            } else if (Language.ALPHABET_UA.contains(content)) {
                return Language.ALPHABET_UA;
            }
        } else {
            if (Language.ALPHABET_ENG_UPPER.contains(content)) {
                return Language.ALPHABET_ENG_UPPER;
            } else if (Language.ALPHABET_UA_UPPER.contains(content)) {
                return Language.ALPHABET_UA_UPPER;
            }
        }
        return null;
    }

    public static ArrayList<String> detectorBF(String content){
        char[] contentCharArray = content.toCharArray();
        for (char c : contentCharArray) {
            char currentChar = Character.toLowerCase(c);
            if (Language.ALPHABET_ENG.contains(currentChar)) {
                return Language.ENG_WORDS_FOR_BRUTEFORCE;
            } else if (Language.ALPHABET_UA.contains(currentChar)) {
                return Language.UKR_WORDS_FOR_BRUTEFORCE;
            }
        }
    return null;
    }
}