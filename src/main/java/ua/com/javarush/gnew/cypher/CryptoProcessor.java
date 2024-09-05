package ua.com.javarush.gnew.cypher;

import java.util.ArrayList;
import java.util.Collections;

public class CryptoProcessor {
    private ArrayList<Character> alphabet;

    public void setAlphabet(ArrayList<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int key){

        ArrayList<Character> alphabetToRotate = new ArrayList<>(alphabet);
        Collections.rotate(alphabetToRotate,-key);
        if(text.isEmpty()){
            throw new IllegalArgumentException("Text to encrypt must contains chars");
        }
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                boolean isUpperCase = Character.isUpperCase(ch);
                int originalPosition = getPositionInAlphabet(ch);
                char newChar = alphabetToRotate.get(originalPosition);
                result.append(isUpperCase ? newChar : Character.toLowerCase(newChar));
            } else {
                result.append(ch);
            }
        }

        return result.toString();

    }

    public String decrypt(String text, int key){
        ArrayList<Character> alphabetToRotate = new ArrayList<>(alphabet);
        Collections.rotate(alphabetToRotate,-key);
        if(text.isEmpty()){
            throw new IllegalArgumentException("Text to encrypt must contains chars");
        }
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                boolean isUpperCase = Character.isUpperCase(ch);
                int originalPosition = alphabetToRotate.indexOf(Character.toUpperCase(ch));
                char newChar = alphabet.get(originalPosition);
                result.append(isUpperCase ? newChar : Character.toLowerCase(newChar));
            } else {
                result.append(ch);
            }
        }

        return result.toString();

    }



    private int getPositionInAlphabet(char ch) {
        return alphabet.indexOf(Character.toUpperCase(ch));
    }


}
