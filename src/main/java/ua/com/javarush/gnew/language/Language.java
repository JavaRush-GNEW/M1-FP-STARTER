package ua.com.javarush.gnew.language;

import java.util.ArrayList;
import java.util.Arrays;
public class Language {
    public static final ArrayList<Character> CON_ALP = new ArrayList<>(Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    ));

    public static final ArrayList<Character> ALP = new ArrayList<>(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    ));

    // Ukrainian alphabet
    public static final ArrayList<Character> UKR_CON_ALP = new ArrayList<>(Arrays.asList(
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я'
    ));

    public static final ArrayList<Character> UKR_ALP = new ArrayList<>(Arrays.asList(
            'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я'
    ));
    public ArrayList<Character> getAlphabet(char symbol) {
        if (CON_ALP.contains(symbol) || ALP.contains(symbol)) {
            return CON_ALP.contains(symbol) ? CON_ALP : ALP;
        } else if (UKR_CON_ALP.contains(symbol) || UKR_ALP.contains(symbol)) {
            return UKR_CON_ALP.contains(symbol) ? UKR_CON_ALP : UKR_ALP;
        } else {
            return null;
        }
    }
}
