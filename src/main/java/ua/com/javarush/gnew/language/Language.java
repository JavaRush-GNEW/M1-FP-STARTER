package ua.com.javarush.gnew.language;

import java.util.List;

public abstract class Language {

    private final List<Character> alphabet;

    public Language(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public List<Character> getAlphabet() {
        return alphabet;
    }

    public int indexOf(char symbol) {
        return alphabet.indexOf(symbol);
    }

    public char get(int index) {
        return alphabet.get(index);
    }

    public int size() {
        return alphabet.size();
    }

    public boolean contains(char symbol) {
        return alphabet.contains(symbol);
    }
}
