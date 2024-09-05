package ua.com.javarush.gnew.cypher;

import ua.com.javarush.gnew.language.Alphabet;

import java.util.ArrayList;
import java.util.List;

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

    public int calculateKey(List<String> text) {
        String encrypted = "";
        String decrypted = "";

        for (String line : text) {
            encrypted = line;
            for (int i = 1; i < 26; i++) {
                decrypted = decrypt(line, i);
                if (checkForCommonWords(decrypted)) {
                    break;
                }
            }
            break;
        }

        int firstLetterIndex = 0;
        for (int i = 0; i < decrypted.length(); i++) {
            if (Character.isLetter(decrypted.charAt(i))) {
                firstLetterIndex = i;
                break;
            }
        }

        int indexEncrypted = Alphabet.ENGLISH_LOWERCASE.indexOf(Character.toLowerCase(encrypted.charAt(firstLetterIndex)));
        int indexDecrypted = Alphabet.ENGLISH_LOWERCASE.indexOf(Character.toLowerCase(decrypted.charAt(firstLetterIndex)));
        if (indexEncrypted < indexDecrypted) {
            indexEncrypted = indexEncrypted + 26;
        }
        return indexEncrypted - indexDecrypted;
    }

    private boolean checkForCommonWords(String text) {
        ArrayList<String> words = getWords(text);
        boolean containsCommonWords = false;

        for (String word : words) {
            if (Alphabet.ENGLISH_COMMON_WORDS.contains(word.toLowerCase())) {
                containsCommonWords = true;
                break;
            }
        }

        return containsCommonWords;
    }

    private static ArrayList<String> getWords(String text) {
        String[] words = text.replaceAll("[^a-zA-Z ]", "").split("\\s+");

        ArrayList<String> wordList = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordList.add(word);
            }
        }

        return wordList;
    }
}