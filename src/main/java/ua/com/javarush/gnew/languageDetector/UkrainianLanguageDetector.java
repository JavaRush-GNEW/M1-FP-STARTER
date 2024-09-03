package ua.com.javarush.gnew.languageDetector;

public class UkrainianLanguageDetector implements LanguageDetector {
    @Override
    public boolean isLanguage(String text) {
        for (char c : text.toLowerCase().toCharArray()) {
            if ("абвгґдежзийклмнопрстуфхцчшщьюяіїє".indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}

