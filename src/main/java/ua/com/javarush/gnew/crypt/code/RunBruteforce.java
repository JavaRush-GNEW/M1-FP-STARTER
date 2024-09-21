package ua.com.javarush.gnew.crypt.code;


import static ua.com.javarush.gnew.Constants.Constants.*;


public class RunBruteforce {

    public String bruteforce(String str, String[] dictionary, String[] dictionaryUKR) {
        String bestMatch = null;
        int maxMatches = 0;
        StringBuilder builder;
        Cryptanalyzer crypt = new Cryptanalyzer();

        for (int key = 0; key <= ENG_LOWER.size(); key++) {
            builder = new StringBuilder(crypt.getDecryption(str, key));
            String decryptedText = builder.toString();
            int matches = countMatches(decryptedText, dictionary);

            if (matches > maxMatches) {
                maxMatches = matches;
                bestMatch = decryptedText;
            }
        }
        for (int key = 0; key <= UKR_LOWER.size(); key++) {
            builder = new StringBuilder(crypt.getDecryption(str, key));
            String decryptedText = builder.toString();
            int matches = countMatches(decryptedText, dictionaryUKR);

            if (matches > maxMatches) {
                maxMatches = matches;
                bestMatch = decryptedText;
            }
        }

        return bestMatch != null ? bestMatch : "Брутфорс не дал результатов.";
    }

    private int countMatches(String text, String[] dictionary) {
        int matches = 0;
        for (String word : dictionary) {
            if (text.contains(word)) {
                matches++;
            }
        }
        return matches;
    }

    public String getKey(String str, String[] dictionary, String[] dictionaryUKR) {
        int maxMatches = 0;
        String keyResult = null;
        StringBuilder builder;
        Cryptanalyzer crypt = new Cryptanalyzer();

        for (int key = 0; key < ENG_LOWER.size(); key++) {
            builder = new StringBuilder(crypt.getDecryption(str, key));
            String decryptedText = builder.toString();
            int matches = countMatches(decryptedText, dictionary);

            if (matches > maxMatches) {
                maxMatches = matches;
                keyResult = "Key: " + key + " (ENG)";
            }
        }

        for (int key = 0; key < UKR_LOWER.size(); key++) {
            builder = new StringBuilder(crypt.getDecryption(str, key));
            String decryptedText = builder.toString();
            int matches = countMatches(decryptedText, dictionaryUKR);

            if (matches > maxMatches) {
                maxMatches = matches;
                keyResult = "Key: " + key + " (UKR)";
            }
        }
        return keyResult != null ? keyResult : "Ключ не найден.";
    }
}



