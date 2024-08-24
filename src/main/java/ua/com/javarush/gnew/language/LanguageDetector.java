package ua.com.javarush.gnew.language;

import java.util.ArrayList;

public class LanguageDetector {


    public static ArrayList<Character> detector(char content){

//        for (int i = 0; i < content.length(); i++) {
//            currentChar = content.charAt(i);
//            if (Character.isLetter(currentChar)){
//                break;
//            }
//        }

        if (Language.ALPHABET_ENG.contains(content)) {
            return Language.ALPHABET_ENG;
        } else if (Language.ALPHABET_ENG_UPPER.contains(content)){
            return Language.ALPHABET_ENG_UPPER;
        } else if (Language.ALPHABET_UA.contains(content)){
            return Language.ALPHABET_UA;
        } else if (Language.ALPHABET_UA_UPPER.contains(content)){
            return Language.ALPHABET_UA_UPPER;
        }

//        TO DO: new return
    return null;
    }


}
