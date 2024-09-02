package ua.com.javarush.gnew.processing;

import ua.com.javarush.gnew.cypher.BruteForce;
import ua.com.javarush.gnew.cypher.CryptoProcessor;
import ua.com.javarush.gnew.cypher.Operation;
import ua.com.javarush.gnew.file.FileOperations;
import ua.com.javarush.gnew.language.Alphabet;

import java.io.IOException;


public class CryptoOperationHandler {
    private final CryptoProcessor cryptoProcessor = new CryptoProcessor();
    private final FileOperations fileOperations = new FileOperations();

    public void handleOperation(Operation mode, String filePath, int key, boolean isBruteForce) throws IOException {
        if (filePath == null || filePath.isEmpty()) {
            System.out.println("File path is required.");
            return;
        }

    String message = fileOperations.readFromFile(filePath);
    Alphabet alphabet = new Alphabet(Alphabet.detectLanguage(message));
    cryptoProcessor.setAlphabet(alphabet.getAlphabet());

    switch(mode) {
        case ENCRYPT:
            if (key == 0) {
                System.out.println("Key is required for encryption.");
                return;
            }
            String encryptedMessage = cryptoProcessor.encrypt(message, key);
            fileOperations.writeToFile(filePath, encryptedMessage, Operation.ENCRYPT);
            System.out.println("File encrypted successfully.");
            break;

        case DECRYPT:
            if (key == 0) {
                System.out.println("Key is required for decryption.");
                return;
            }
            String decryptedMessage = cryptoProcessor.decrypt(message, key);
            fileOperations.writeToFile(filePath, decryptedMessage, Operation.DECRYPT);
            System.out.println("File decrypted successfully.");
            break;

        case BRUTE_FORCE:
            if (isBruteForce) {
                BruteForce bruteForce = new BruteForce(Alphabet.detectLanguage(message));
                int foundKey = bruteForce.getKey(filePath);
                String bruteForcedMessage = cryptoProcessor.decrypt(message, foundKey);
                fileOperations.writeToFile(filePath, bruteForcedMessage, Operation.BRUTE_FORCE);
                System.out.println("File decrypted using brute-force successfully with key: " + foundKey);
            }
            break;

        default:
            System.out.println("Invalid mode selected.");
            break;
    }
}


}


