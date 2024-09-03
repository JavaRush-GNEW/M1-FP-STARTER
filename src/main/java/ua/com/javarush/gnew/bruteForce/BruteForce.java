package ua.com.javarush.gnew.bruteForce;

import ua.com.javarush.gnew.languageDetector.EnglishLanguageDetector;
import ua.com.javarush.gnew.languageDetector.LanguageDetector;
import ua.com.javarush.gnew.crypto.EncryptionUtil;

import java.util.List;
import java.util.Set;

public class BruteForce {
    private final EncryptionUtil encryptionUtil = new EncryptionUtil();
    private final DecryptionHelper decryptionHelper = new DecryptionHelper();

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

    // Українські слова, суфікси та рідкісні комбінації
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

    public int brute_force(String s) {
        int result = 0;
        int maxPopular = 0;

        LanguageDetector englishDetector = new EnglishLanguageDetector();
        boolean isEnglish = englishDetector.isLanguage(s);
        int alphabetSize = isEnglish ? 26 : 33;

        for (int i = 0; i < alphabetSize; i++) {
            String decrypted = encryptionUtil.decrypt(s, i);
            int popular = isEnglish ?
                    decryptionHelper.evaluateText(decrypted, COMMON_WORDS_EN, COMMON_ENDINGS_EN, RARE_COMBINATIONS_EN) :
                    decryptionHelper.evaluateText(decrypted, COMMON_WORDS_UA, COMMON_ENDINGS_UA, RARE_COMBINATIONS_UA);
            if (popular > maxPopular) {
                maxPopular = popular;
                result = i;
            }
        }
        return result;
    }
}

