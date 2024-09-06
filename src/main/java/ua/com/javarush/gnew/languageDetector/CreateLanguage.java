package ua.com.javarush.gnew.languageDetector;

public class CreateLanguage {

    public LanguageDetector createLanguageStrategy(String text) {
        if (isEnglish(text)) {
            return new EnglishLanguageDetector();
        } else if (isUkrainian(text)) {
            return new UkrainianLanguageDetector();
        } else {
            throw new IllegalArgumentException("Unsupported language detected.");
        }
    }

    private boolean isEnglish(String text) {
        for (char c : text.toLowerCase().toCharArray()) {
            if ("abcdefghijklmnopqrstuvwxyz".indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean isUkrainian(String text) {
        for (char c : text.toLowerCase().toCharArray()) {
            if ("абвгґдежзийклмнопрстуфхцчшщьюяіїє".indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}
