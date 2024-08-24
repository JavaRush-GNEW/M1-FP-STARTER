package ua.com.javarush.gnew.crypto;

import ua.com.javarush.gnew.language.LanguageDetector;

import java.util.ArrayList;
import java.util.Collections;

public class ProcessSymbol {
    protected static Character processSymbol(char currentChar, int key) {
        ArrayList<Character> originalAlphabet = LanguageDetector.detector(currentChar);
        if (originalAlphabet == null){
            return currentChar;
        }
        ArrayList<Character> rotatedAlphabet = new ArrayList<>(originalAlphabet);
        Collections.rotate(rotatedAlphabet, key);
        int index =  originalAlphabet.indexOf(currentChar);
        return rotatedAlphabet.get(index);
    }
}
