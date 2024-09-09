package ua.com.javarush.gnew.crypto;

import java.util.ArrayList;
import java.util.Collections;

public class Rotator {

    protected ArrayList<Character> rotateAlphabet(int key){


        ArrayList<Character> rotateAlphabet = new ArrayList<>(ConstantsForCryptor.ALPHABET.getCharsArrayConstant());
        Collections.rotate(rotateAlphabet, key);
        return rotateAlphabet;
    }

    protected ArrayList<Character> rotatePunctuation(Integer key){
        ArrayList<Character> rotatePunctuation = new ArrayList<>(ConstantsForCryptor.PUNCTUATION.getCharsArrayConstant());
        Collections.rotate(rotatePunctuation, key);
        return rotatePunctuation;
    }

}
