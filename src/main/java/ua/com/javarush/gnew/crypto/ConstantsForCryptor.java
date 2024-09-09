package ua.com.javarush.gnew.crypto;

import java.util.ArrayList;
import java.util.Arrays;

public enum ConstantsForCryptor {
    ALPHABET(new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z'))),
    PUNCTUATION (new ArrayList<>(Arrays.asList(' ', ',', '!', '?', ':', ';', '-',
            '(', ')', '[', ']', '{', '}','#', '.', '@', '*', '+', '=', '_', '&',
            '\\', '/', '₴', '~', '`')));

    private final ArrayList<Character> CHARS_ARRAY_CONSTANT;

    ConstantsForCryptor(ArrayList<Character> CHARS_ARRAY_CONSTANS) {
        this.CHARS_ARRAY_CONSTANT = CHARS_ARRAY_CONSTANS;
    }
    public ArrayList<Character> getCharsArrayConstant() {
        return this.CHARS_ARRAY_CONSTANT;
    }
}
