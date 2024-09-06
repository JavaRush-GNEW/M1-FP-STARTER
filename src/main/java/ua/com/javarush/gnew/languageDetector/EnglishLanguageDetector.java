package ua.com.javarush.gnew.languageDetector;

import java.util.List;
import java.util.Set;

public class EnglishLanguageDetector implements LanguageDetector {
    private static final Set<String> COMMON_WORDS_EN = Set.of(
            "the", "be", "to", "of", "and", "in", "that", "have", "I",
            "it", "for", "not", "on", "with", "he", "as", "you", "do", "at",
            "this", "but", "his", "by", "from", "they", "we", "say", "her",
            "she", "or", "an", "will", "my", "one", "all", "would", "there",
            "their", "what", "so", "up", "out", "if", "about", "who", "get",
            "which", "go", "me"
    );

    private static final List<String> COMMON_ENDINGS_EN = List.of(
            "ing", "ed", "s", "es", "ly", "er", "est", "ness",
            "ful", "less", "tion", "able", "ive", "ous", "ment"
    );

    private static final List<String> RARE_COMBINATIONS_EN = List.of(
            "qj", "qx", "vw", "zk", "kp", "xq", "jh", "bv", "zx",
            "qq", "ww", "xx", "zz", "vv", "hh", "kk"
    );

    @Override
    public Set<String> getCommonWords() {
        return COMMON_WORDS_EN;
    }

    @Override
    public List<String> getCommonEndings() {
        return COMMON_ENDINGS_EN;
    }

    @Override
    public List<String> getRareCombinations() {
        return RARE_COMBINATIONS_EN;
    }

    @Override
    public int getAlphabetSize() {
        return 26;
    }
}

