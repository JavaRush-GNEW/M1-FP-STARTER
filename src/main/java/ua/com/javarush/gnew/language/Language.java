package ua.com.javarush.gnew.language;

import java.util.ArrayList;
import java.util.Arrays;

public class Language {
    public static final ArrayList<Character> ALPHABET_ENG = new ArrayList<>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

    public static final ArrayList<Character> ALPHABET_UA = new ArrayList<>(Arrays.asList(
            'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м',
            'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я'));

    public static final ArrayList<Character> ALPHABET_ENG_UPPER = new ArrayList<>(Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

    public static final ArrayList<Character> ALPHABET_UA_UPPER = new ArrayList<>(Arrays.asList(
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М',
            'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я'));

    public static final ArrayList<String> ENG_WORDS_FOR_BRUTEFORCE = new ArrayList<>(Arrays.asList(
            "the", "and", "you", "that", "was", "for", "are", "with", "his", "they", "this"));

    public static final ArrayList<String> UKR_WORDS_FOR_BRUTEFORCE = new ArrayList<>(Arrays.asList(
            "щоб", "але", "він", "від", "вони", "бути", "його"));

}
