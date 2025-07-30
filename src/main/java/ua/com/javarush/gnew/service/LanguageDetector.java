package ua.com.javarush.gnew.service;

import ua.com.javarush.gnew.language.EnglishLanguage;
import ua.com.javarush.gnew.language.Language;
import ua.com.javarush.gnew.language.UkrainianLanguage;

import java.util.List;

public class LanguageDetector {
    private static final double PROBABILITY_COEFFICIENT = 0.7;
    private final List<Language> languages = List.of(new EnglishLanguage(), new UkrainianLanguage());

    public Language detect(String text) {
        for (Language language : languages) {
            long count = text.chars()
                    .filter(symbol -> language.getAlphabet().contains((char) symbol)).count();

            double ration = (double) count / text.length();

            if (ration > PROBABILITY_COEFFICIENT) {
                return language;
            }
        }
        return new EnglishLanguage();
    }
}
