package ua.com.javarush.gnew.languageDetector;

public class EnglishLanguageDetector implements LanguageDetector {
    @Override
    public boolean isLanguage(String text) {
        for (char c : text.toLowerCase().toCharArray()) {
            if ("abcdefghijklmnopqrstuvwxyz".indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}

