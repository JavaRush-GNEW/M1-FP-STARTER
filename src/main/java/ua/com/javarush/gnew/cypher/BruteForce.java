package ua.com.javarush.gnew.cypher;

import ua.com.javarush.gnew.file.FileOperations;
import ua.com.javarush.gnew.language.Alphabet;
import ua.com.javarush.gnew.language.Language;

import java.util.*;

public class BruteForce {
    private final Set<String> dataSet;
    private final Language language;
    private final FileOperations fileOperations;
    private final CryptoProcessor cryptoProcessor;

    public BruteForce(Language language){
        this.fileOperations = new FileOperations();
        this.cryptoProcessor = new CryptoProcessor();
        this.language = language;
        String text;

        // loading train data depends on select language
        switch (language){
            case UA -> text = fileOperations.readFromFile("D:\\Web2024\\M1-FP-EUGENE-CYPHER\\src\\test\\resources\\bruteForceUA.txt");
            case ENG -> text = fileOperations.readFromFile("D:\\Web2024\\M1-FP-EUGENE-CYPHER\\src\\test\\resources\\bruteForceENG.txt");
            default -> throw new IllegalStateException("Unexpected value: " + language);
        }
        // form the vocabulary
        this.dataSet = new HashSet<>(Arrays.asList(text.split("[,\\.\\s]+")));
    }


    public int getKey(String path){
        if(path == null || path.isEmpty()){
            throw new IllegalArgumentException("Path cannot be empty");
        }
        HashMap<Integer,Integer> accuracyMap = new HashMap<>();
        FileOperations fileOperations = new FileOperations();
        String encryptText = fileOperations.readFromFile(path);
        Alphabet alphabet = new Alphabet(language);
        CryptoProcessor cryptoProcessor = new CryptoProcessor();
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
