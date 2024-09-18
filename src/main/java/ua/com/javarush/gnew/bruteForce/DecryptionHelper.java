package ua.com.javarush.gnew.bruteForce;

import java.util.List;
import java.util.Set;

public class DecryptionHelper {

    public int evaluateText(String s, Set<String> commonWords, List<String> commonEndings, List<String> rareCombinations) {
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

