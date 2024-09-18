package ua.com.javarush.gnew.bruteForce;

import ua.com.javarush.gnew.languageDetector.CreateLanguage;
import ua.com.javarush.gnew.languageDetector.EnglishLanguageDetector;
import ua.com.javarush.gnew.languageDetector.LanguageDetector;
import ua.com.javarush.gnew.crypto.EncryptionUtil;

import java.util.List;
import java.util.Set;

public class BruteForce {
    private final EncryptionUtil encryptionUtil = new EncryptionUtil();
    private final DecryptionHelper decryptionHelper = new DecryptionHelper();

    public int brute_force(String s) {
        int result = 0;
        int maxPopular = 0;

        LanguageDetector languageStrategy = new CreateLanguage().createLanguageStrategy(s);

        int alphabetSize = languageStrategy.getAlphabetSize();

        for (int i = 0; i < alphabetSize; i++) {
            String decrypted = encryptionUtil.decrypt(s, i);
            int popular = decryptionHelper.evaluateText(decrypted,
                    languageStrategy.getCommonWords(),
                    languageStrategy.getCommonEndings(),
                    languageStrategy.getRareCombinations());
            if (popular > maxPopular) {
                maxPopular = popular;
                result = i;
            }
        }
        return result;
    }
}

