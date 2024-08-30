package ua.com.javarush.gnew.language;

import java.util.ArrayList;

public class Alphabet {

    private Language language;

    private ArrayList<Character> alphabet;

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
        String ukrainianSpecificLetters = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";

        for (char c : text.toCharArray()) {
            if (ukrainianSpecificLetters.indexOf(Character.toUpperCase(c)) >= 0) {
                return Language.UA;
            }
        }

        return Language.ENG;
    }

    public ArrayList<Character> getAlphabet() {
        return alphabet;
    }





}
