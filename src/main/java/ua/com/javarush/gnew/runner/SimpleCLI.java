package ua.com.javarush.gnew.runner;

import picocli.CommandLine;
import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.file.FileManager;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class SimpleCLI implements Runnable {
    private final FileManager fileManager = new FileManager();
    private final Cypher cypher = new Cypher();
    Scanner console = new Scanner(System.in);
    /**
     * -e Encrypt
     * -d Decrypt
     * -bf Brute force
     * -k Key
     * -f File path
     */

    @CommandLine.Option(names = {"-e", "ENCRYPT"}, description = "Encrypt", defaultValue = "false")
    private boolean encrypt;
    @CommandLine.Option(names = {"-d", "DECRYPT"}, description = "Decrypt", defaultValue = "false")
    private boolean decrypt;
    @CommandLine.Option(names = {"-bf", "--brute-force"}, description = "Brute force", defaultValue = "false")
    private boolean bruteForce;
    @CommandLine.Option(names = {"-f", "--file"}, description = "File path", arity = "0..1", interactive = true)
    Path file;
    //    @CommandLine.Option(names = { "-k", "--key" },  description = "Key", defaultValue = "0")
    @CommandLine.Option(names = {"-k", "--key"}, arity = "0..1", interactive = true)
    Integer key;

//,defaultValue = "0"

    @Override
    public void run() {
//        System.out.println(" Encrypt: "+encrypt+";\n Decrypt: "+decrypt+";\n Brute force: "+bruteForce
//                + ";\n File path: "+file.getParent()+";\n Key: "+key);

//       key = Math.abs(key);
        if ( file == null) {
            System.out.print("Enter value for --file: ");
            file = Path.of(console.nextLine());
        }
        if (!bruteForce && key == null) {
            System.out.print("Enter value for --key: ");
            key = console.nextInt();
        }

        if (encrypt) {
            try {
                String mess = fileManager.read(file);
                String fileName = file.getFileName().toString();
                String newFileName = fileName.substring(0, fileName.length() - 4) + " [ENCRYPTED].txt";
                Path out = (file.resolveSibling(newFileName));
//                System.out.println(out);
                String encryptedData = cypher.encrypt(mess, key);
//                System.out.println(encryptedData);
                fileManager.write(out, encryptedData);

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        if (decrypt) {
            try {
                String mess = fileManager.read(file);
                String fileName = file.getFileName().toString().replaceAll(" \\[ENCRYPTED\\]", "");
                String newFileName = fileName.substring(0, fileName.length() - 4) + " [DECRYPTED].txt";
                Path out = (file.resolveSibling(newFileName));
//                System.out.println(out);
                String encryptedData = cypher.decrypt(mess, key);
//                System.out.println(encryptedData);
                fileManager.write(out, encryptedData);

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }

        if (bruteForce) {
            try {
                String mess = fileManager.read(file);
                String fileName = file.getFileName().toString().replaceAll(" \\[ENCRYPTED\\]", "");
                String newFileName = fileName.substring(0, fileName.length() - 4) + " [DECRYPTED].txt";
                Path out = (file.resolveSibling(newFileName));
//                System.out.println(out);
                key = cypher.analyzeFrequency(mess);
//                System.out.println("Key: "+key);
                String encryptedData = cypher.decrypt(mess, key);
//                System.out.println(encryptedData);
                fileManager.write(out, encryptedData);

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }


    }
}

