package ua.com.javarush.gnew.service;

public class TextAnalyzer {
    private static final int PUNCTUATION_COEFFICIENT = 2;
    private static final int LENGTH_COEFFICIENT = 5;

    public int evaluate(String text) {
        int score = 0;
        score += countMatches(text, ' ') * PUNCTUATION_COEFFICIENT;
        score += countMatches(text, '.') * PUNCTUATION_COEFFICIENT;
        score += countMatches(text, ',') * PUNCTUATION_COEFFICIENT;
        score += countMatches(text, '!') * PUNCTUATION_COEFFICIENT;
        score += countMatches(text, '?') * PUNCTUATION_COEFFICIENT;

        if (text.matches(".*[а-яА-Яa-zA-Z]{4,}.*")) {
            score += LENGTH_COEFFICIENT;
        }
        return score;
    }

    private int countMatches(String text, char symbol) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == symbol) {
                count++;
            }
        }
        return count;
    }
}
