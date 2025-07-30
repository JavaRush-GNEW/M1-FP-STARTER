package ua.com.javarush.gnew.language;

import java.util.List;

public class UkrainianLanguage extends Language {
    private static final List<Character> UKRAINIAN_ALPHABET = List.of('А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З',
            'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П',
            'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ь', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з',
            'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п',
            'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ь', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '
    );

    public UkrainianLanguage() {
        super(UKRAINIAN_ALPHABET);
    }
}
