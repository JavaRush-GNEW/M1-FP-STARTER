package ua.com.javarush.gnew.cypher;

import ua.com.javarush.gnew.language.Alphabet;

import java.util.ArrayList;

public class Cypher {

    public String encrypt(String text, int key) {

        ArrayList<Character> rotatedUppercase = Alphabet.rotateAlphabet(Alphabet.ENGLISH_UPPERCASE, key);
        ArrayList<Character> rotatedLowercase = Alphabet.rotateAlphabet(Alphabet.ENGLISH_LOWERCASE, key);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char oneChar = text.charAt(i); // беремо символ з тексту
            int index = Alphabet.ENGLISH_LOWERCASE.indexOf(oneChar); // шукаємо його в алфавіті lowercase
            if (index != -1) { // якщо знайшли
                result.append(rotatedLowercase.get(index)); // шифруємо і додаємо до результату
            } else { // якщо немає
                index = Alphabet.ENGLISH_UPPERCASE.indexOf(oneChar); // шукаємо його в алфавіті uppercase
                if (index != -1) { // якщо знайшли
                    result.append(rotatedUppercase.get(index)); // шифруємо і додаємо до результату
                } else { // якщо не знайшли в жодному з двох алфавітів, це спеціальний символ
                    result.append(text.charAt(i)); // НЕ шифруємо і просто додаємо
                }
            }
        }
        return result.toString();
    }

    public String decrypt(String text, int key) {
        // decrypt робить те саме, що й encrypt, тільки з протилежним значенням ключа
        return encrypt(text, -key);
    }
}