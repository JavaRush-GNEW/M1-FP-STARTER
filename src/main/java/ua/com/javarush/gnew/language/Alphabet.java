package ua.com.javarush.gnew.language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public abstract class Alphabet {

    public static final ArrayList<Character> ENGLISH_UPPERCASE = new ArrayList<>(Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
    public static final ArrayList<Character> ENGLISH_LOWERCASE = new ArrayList<>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

    public static ArrayList<Character> rotateAlphabet(ArrayList<Character> originalAlphabet, int key) {

        ArrayList<Character> rotatedAlphabet = new ArrayList<>(originalAlphabet);

        Collections.rotate(rotatedAlphabet, -key);

        return rotatedAlphabet;
    }
}