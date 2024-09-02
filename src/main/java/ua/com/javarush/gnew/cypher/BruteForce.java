package ua.com.javarush.gnew.cypher;

import ua.com.javarush.gnew.file.FileOperations;
import ua.com.javarush.gnew.language.Alphabet;
import ua.com.javarush.gnew.language.Language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class BruteForce {
    private final Set<String> dataSet;
    private final Language language;
    private final FileOperations fileOperations;
    private final CryptoProcessor cryptoProcessor;

    public BruteForce(Language language) {
        this.fileOperations = new FileOperations();
        this.cryptoProcessor = new CryptoProcessor();
        this.language = language;
        String text;

        // Loading training data depending on selected language
        switch (language) {
            case UA -> text = readFromResource("bruteForceUA.txt");
            case ENG -> text = readFromResource("bruteForceENG.txt");
            default -> throw new IllegalStateException("Unexpected value: " + language);
        }
        // Form the vocabulary
        this.dataSet = new HashSet<>(Arrays.asList(text.split("[,\\.\\s]+")));
    }

    // Method to read from resources
    private String readFromResource(String resourcePath) {
        StringBuilder result = new StringBuilder();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }


    public int getKey(String path){
        if(path == null || path.isEmpty()){
            throw new IllegalArgumentException("Path cannot be empty");
        }
        HashMap<Integer,Integer> accuracyMap = new HashMap<>();
        String encryptText = fileOperations.readFromFile(path);
        Alphabet alphabet = new Alphabet(language);
        cryptoProcessor.setAlphabet(alphabet.getAlphabet());
        String decryptText;
        for (int i = 1; i <= 26 ; i++) {
            decryptText = cryptoProcessor.decrypt(encryptText,i);
            String[] decryptArray = decryptText.split("[,\\.\\s]+");
            int matches = 0;
            for (String dec: decryptArray){
                if(dataSet.contains(dec)){
                    matches++;
                    accuracyMap.put(i,matches);

                }
            }
        }
        return getMax(accuracyMap);
    }

    private int getMax(HashMap<Integer,Integer> accuracyMap){
        int maxValue = Integer.MIN_VALUE;
        int key = 1;
        for (int score: accuracyMap.keySet()) {
            if(accuracyMap.get(score)>maxValue){
                maxValue = accuracyMap.get(score);
                key = score;
            }

        } return key;
    }

}
