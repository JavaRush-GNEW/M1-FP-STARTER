package ua.com.javarush.gnew.crypto;

import java.util.*;

public class Cypher {
    public static int key;
    private final ArrayList<Character> originalAlphabet = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));


    public String encrypt(String input, int key) {
        key = -key;

        ArrayList<Character> rotatedAlphabet = new ArrayList<>(originalAlphabet);
        Collections.rotate(rotatedAlphabet, key);
        char[] charArray = input.toCharArray();

        StringBuilder builder = new StringBuilder();
        for (char symbol : charArray) {
            builder.append(processSymbol(symbol, rotatedAlphabet));
        }
        return builder.toString();
    }

    public String decrypt(String input, int key) {
        return encrypt(input, -key);
    }

    public String bruteForce(String input) {
        int maxCount = 0;
        int key = 0;
        String bestOutput ="";
        HashSet<String> engWords = new HashSet<>(List.of("are", "not", "am", "get", "do", "the", "be", "and", "to", "of", "have", "you", "at", "for", "was"));


        for (int i = 1; i <= 25; i++) {
            ArrayList<Character> rotatedAlphabet = new ArrayList<>(originalAlphabet);
            Collections.rotate(rotatedAlphabet, i);
            char[] charArray = input.toCharArray();

            StringBuilder builder = new StringBuilder();
            for (char symbol : charArray) {
                builder.append(processSymbol(symbol, rotatedAlphabet));
            }
            String output = builder.toString();

            int count = 0;
            String[] words = output.split("\\s+");
            for (String word : words) {
                if (engWords.contains(word.toLowerCase())) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                key = i;
                bestOutput = output;
            }
        }
        Cypher.key = key;
        return bestOutput;
    }

    private Character processSymbol(char symbol, ArrayList<Character> rotatedAlphabet) {
        if (!originalAlphabet.contains(symbol)) {
            return symbol;
        }
        int index = originalAlphabet.indexOf(symbol);

        return rotatedAlphabet.get(index);
    }
}
