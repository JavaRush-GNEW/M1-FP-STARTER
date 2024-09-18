package ua.com.javarush.gnew.languageDetector;

import java.util.List;
import java.util.Set;

public class UkrainianLanguageDetector implements LanguageDetector {
    private static final Set<String> COMMON_WORDS_UA = Set.of(
            "і", "в", "на", "що", "з", "не", "до", "це", "як", "я",
            "він", "ти", "ми", "вона", "ви", "вони", "цей", "той",
            "який", "яка", "воно", "якщо", "але", "тому", "вже", "був", "була",
            "було", "та", "бо", "коли", "де", "про", "його", "її", "їх"
    );

    private static final List<String> COMMON_ENDINGS_UA = List.of(
            "ий", "ого", "ому", "ім", "ими", "ий", "им", "ів", "ити", "имо",
            "ти", "ла", "ло", "ли", "ти", "ть", "є", "но", "ено", "єно",
            "ан", "ен", "ян", "к", "че", "ка", "чи"
    );

    private static final List<String> RARE_COMBINATIONS_UA = List.of(
            "цщ", "шщ", "жщ", "йй", "шч", "щц", "щщ", "фг", "фз", "гф",
            "йй", "юя", "аї", "яє", "йг", "гщ", "щж", "щш", "щр", "цф"
    );

    @Override
    public Set<String> getCommonWords() {
        return COMMON_WORDS_UA;
    }

    @Override
    public List<String> getCommonEndings() {
        return COMMON_ENDINGS_UA;
    }

    @Override
    public List<String> getRareCombinations() {
        return RARE_COMBINATIONS_UA;
    }

    @Override
    public int getAlphabetSize() {
        return 33;
    }
}

