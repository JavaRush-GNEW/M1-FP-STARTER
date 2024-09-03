package ua.com.javarush.gnew.crypto;

import java.util.List;
import java.util.Set;

public class BruteForce {
    public static final Set<String> commonWordsEn = Set.of(
            "the", "be", "to", "of", "and", "in", "that", "have", "I",
            "it", "for", "not", "on", "with", "he", "as", "you", "do", "at",
            "this", "but", "his", "by", "from", "they", "we", "say", "her",
            "she", "or", "an", "will", "my", "one", "all", "would", "there",
            "their", "what", "so", "up", "out", "if", "about", "who", "get",
            "which", "go", "me"
    );

    public static final List<String> commonEndingsEn = List.of(
            "ing", "ed", "s", "es", "ly", "er", "est", "ness",
            "ful", "less", "tion", "able", "ive", "ous", "ment"
    );

    public static final List<String> rareCombinationsEn = List.of(
            "qj", "qx", "vw", "zk", "kp", "xq", "jh", "bv", "zx",
            "qq", "ww", "xx", "zz", "vv", "hh", "kk"
    );

    public static final Set<String> commonWordsUa = Set.of(
            "і", "в", "на", "що", "з", "не", "до", "це", "як", "я",
            "він", "ти", "ми", "вона", "ви", "вони", "цей", "той",
            "який", "яка", "воно", "якщо", "але", "тому", "вже", "був", "була",
            "було", "та", "бо", "коли", "де", "про", "його", "її", "їх"
    );

    public static final List<String> commonEndingsUa = List.of(
            "ий", "ого", "ому", "ім", "ими", "ий", "им", "ів", "ити", "имо",
            "ти", "ла", "ло", "ли", "ти", "ть", "є", "но", "ено", "єно",
            "ан", "ен", "ян", "к", "че", "ка", "чи"
    );

    public static final List<String> rareCombinationsUa = List.of(
            "цщ", "шщ", "жщ", "йй", "шч", "щц", "щщ", "фг", "фз", "гф",
            "йй", "юя", "аї", "яє", "йг", "гщ", "щж", "щш", "щр", "цф"
    );

    public static int brute_force(String s) {
        int result = 0;
        int maxPopular = 0;
        boolean isEnglish = detectLanguage(s);
        int alphabetSize = isEnglish ? 26 : 33;

        for (int i = 0; i < alphabetSize; i++) {
            String decrypted = EncryptionUtil.decrypt(s, i);
            int popular = isEnglish ? help_brute_force(decrypted, commonWordsEn, commonEndingsEn, rareCombinationsEn)
                    : help_brute_force(decrypted, commonWordsUa, commonEndingsUa, rareCombinationsUa);
            if (popular > maxPopular) {
                maxPopular = popular;
                result = i;
            }
        }
        return result;
    }

    private static boolean detectLanguage(String s) {
        for (char c : s.toLowerCase().toCharArray()) {
            if ("abcdefghijklmnopqrstuvwxyz".indexOf(c) != -1) {
                return true;
            } else if ("абвгґдежзийклмнопрстуфхцчшщьюяіїє".indexOf(c) != -1) {
                return false;
            }
        }
        return true;
    }

    private static int help_brute_force(String s, Set<String> commonWords, List<String> commonEndings, List<String> rareCombinations) {
        String[] words = s.split("\\s+");
        int popular = 0;

        for (String word : words) {
            word = word.replaceAll("[^a-zA-Zа-яА-ЯіІїЇєЄґҐ]", "").toLowerCase();

            for (String rare : rareCombinations) {
                if (word.contains(rare)) {
                    return 0;
                }
            }

            if (commonWords.contains(word)) {
                popular++;
            }

            for (String ending : commonEndings) {
                if (word.endsWith(ending)) {
                    popular++;
                    break;
                }
            }
        }

        return popular;
    }
}
