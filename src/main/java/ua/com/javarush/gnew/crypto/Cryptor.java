package ua.com.javarush.gnew.crypto;


import java.util.HashMap;
import java.util.Map;

public class Cryptor  {

    private String input ;
    private int key;

    public Cryptor(String input, int key){
        this.input =input ;
        this.key = key;
    }


    public Cryptor(String input){
        this.input = input;
    }

    public String cypher() {

        Rotator rotator = new Rotator();

        char[] charsArray = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        SymbolsBelonging symBel = new SymbolsBelonging();
        for(char symbol : charsArray) {
            if(ConstantsForCryptor.ALPHABET.getCharsArrayConstant().contains(Character.toUpperCase(symbol))){
                sb.append(symBel.symbolsBelongingABC(symbol, rotator.rotateAlphabet(key)));
            }else if (ConstantsForCryptor.PUNCTUATION.getCharsArrayConstant().contains(symbol)) {
                sb.append(symBel.symbolsBelongingPUNCTUATION(symbol, rotator.rotatePunctuation(key)));
            }else {
                sb.append(symbol);
            }
        }
        return sb.toString();
    }

    public char MostFrequentChar(){

        char[] charsArray = input.toCharArray();

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char symbol :  charsArray){
            frequencyMap.put(symbol, frequencyMap.getOrDefault(symbol, 0) + 1);
        }

        char mostFrequentChar = '\0';
        int maxFrequency = 0;

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequentChar = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        return mostFrequentChar;
    }

}
