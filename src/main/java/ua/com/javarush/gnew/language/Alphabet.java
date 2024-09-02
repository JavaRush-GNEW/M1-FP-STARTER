package ua.com.javarush.gnew.language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Alphabet {

    private Language language;

    private ArrayList<Character> alphabet;

    private static final Map<Language, String> LANGUAGE_SPECIFIC_LETTERS = new HashMap<>();

    static {
        LANGUAGE_SPECIFIC_LETTERS.put(Language.UA, "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ");
        LANGUAGE_SPECIFIC_LETTERS.put(Language.ENG, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        // other languages can be added
    }

    public Alphabet(Language language) {
        this.language = language;
        this.alphabet = new ArrayList<>();
        initializeAlphabet();
    }


    private void initializeAlphabet() {
        switch (language) {
            case ENG:
                for (char c = 'A'; c <= 'Z'; c++) {
                    alphabet.add(c);
                }
                break;
            case UA:
                String upperUkrainianAlphabet = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
                for (char c : upperUkrainianAlphabet.toCharArray()) {
                    alphabet.add(c);
                }
                break;
        }
    }
    public static Language detectLanguage(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }

        text = text.toUpperCase();

        for (Map.Entry<Language, String> entry : LANGUAGE_SPECIFIC_LETTERS.entrySet()) {
            String specificLetters = entry.getValue();
            for (char c : text.toCharArray()) {
                if (specificLetters.indexOf(c) >= 0) {
                    return entry.getKey();
                }
            }
        }

        return Language.UNKNOWN;
    }

    public ArrayList<Character> getAlphabet() {
        return alphabet;
    }





}
