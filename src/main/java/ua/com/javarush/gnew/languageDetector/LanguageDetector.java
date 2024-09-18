package ua.com.javarush.gnew.languageDetector;

import java.util.List;
import java.util.Set;

public interface LanguageDetector {
    Set<String> getCommonWords();
    List<String> getCommonEndings();
    List<String> getRareCombinations();
    int getAlphabetSize();
}

