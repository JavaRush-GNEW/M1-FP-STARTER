package ua.com.javarush.gnew.bruteForce;

import ua.com.javarush.gnew.crypto.EncryptionUtil;
import ua.com.javarush.gnew.language.Language;
import ua.com.javarush.gnew.languageDetector.CreateLanguage;
import ua.com.javarush.gnew.languageDetector.LanguageDetector;

import java.util.*;

public class FrequencyAnalysis {
    private int key_bf = 0;
    private final DecryptionHelper decryptionHelper = new DecryptionHelper();
    public int getKey_bf(){
        return key_bf;
    }

    public String analysis(String encryptedText, String referenceText) {
        LanguageDetector languageDetector = new CreateLanguage().createLanguageStrategy(encryptedText);

        HashMap<Character, Integer> mapEncrypted = getMap(encryptedText);
        HashMap<Character, Integer> mapReference = getMap(referenceText);

        List<Map.Entry<Character, Integer>> listEncrypted = new ArrayList<>(mapEncrypted.entrySet());
        List<Map.Entry<Character, Integer>> listReference = new ArrayList<>(mapReference.entrySet());

        List<Character> alphabet = new Language().getAlphabet(listReference.get(0).getKey());

        sortByValue(listEncrypted);
        sortByValue(listReference);

        String bestDecryption = null;
        int bestKey = 0;
        int maxPopularity = 0;

        int iterations = Math.min(3, Math.min(listEncrypted.size(), listReference.size()));

        for (int k = 0; k < iterations; k++) {
            char encryptedLetter = listEncrypted.get(k).getKey();
            char referenceLetter = listReference.get(k).getKey();

            // Обчислюємо ключ
            int key = (alphabet.indexOf(encryptedLetter) - alphabet.indexOf(referenceLetter) + languageDetector.getAlphabetSize()) % languageDetector.getAlphabetSize();

            // Дешифруємо текст з поточним ключем
            String decryptedText = new EncryptionUtil().decrypt(encryptedText, key);

            // Оцінюємо розшифрований текст
            int popularity = decryptionHelper.evaluateText(
                    decryptedText,
                    languageDetector.getCommonWords(),
                    languageDetector.getCommonEndings(),
                    languageDetector.getRareCombinations()
            );

            // Оновлюємо найкращий ключ, якщо розшифрований текст популярніший
            if (popularity > maxPopularity) {
                maxPopularity = popularity;
                bestKey = key;
                bestDecryption = decryptedText;
            }
        }
        key_bf = bestKey;

        return bestDecryption;
    }

    private HashMap<Character, Integer> getMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        return map;
    }

    private void sortByValue(List<Map.Entry<Character, Integer>> list) {
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
    }
}
