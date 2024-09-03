package ua.com.javarush.gnew;

import ua.com.javarush.gnew.arg.ArgumentParser;
import ua.com.javarush.gnew.arg.Arguments;
import ua.com.javarush.gnew.crypto.BruteForce;
import ua.com.javarush.gnew.crypto.EncryptionUtil;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.file.NewFileName;


public class Main {

    public static void main(String[] args) {
        try {
            Arguments arguments = ArgumentParser.parse(args);

            String content = FileManager.read(arguments.getFilePath());
            String result;
            String newFile;

            if (arguments.isEncryptionMode()) {
                result = EncryptionUtil.encrypt(content, arguments.getKey());
                newFile = NewFileName.getNewFileName(arguments.getFilePath(), "[ENCRYPTED]");
            } else if (arguments.isDecryptionMode()) {
                result = EncryptionUtil.decrypt(content, arguments.getKey());
                newFile = NewFileName.getNewFileName(arguments.getFilePath(), "[DECRYPTED]");
            } else if (arguments.isBruteForce()) {
                int key = BruteForce.brute_force(content);
                result = EncryptionUtil.decrypt(content, key);
                newFile = NewFileName.getNewFileName(arguments.getFilePath(), "[DECRYPTED]");
                System.out.println("Key found using brute force: " + key);
            } else {
                throw new IllegalArgumentException("Invalid mode. Use '-e' for encryption, '-d' for decryption, or '-bf' for brute force.");
            }

            FileManager.write(newFile, result);
            System.out.println("Operation completed successfully. Output file: " + newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//public static final ArrayList<Character> CON_ALP = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
//public static final ArrayList<Character> ALP = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

//public static void encrypt(String file, int key) throws IOException {
//    String newFile = getNewFileName(file, "[ENCRYPTED]");
//
//    try (BufferedReader reader = new BufferedReader(new FileReader(file));
//         BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
//
//        String s;
//        boolean isFirstLine = true;
//        while ((s = reader.readLine()) != null) {
//            if (!isFirstLine) {
//                writer.newLine(); // Додаємо новий рядок лише після першого рядка
//            }
//            isFirstLine = false;
//
//            char[] chars = s.toCharArray();
//            for (char c : chars) {
//                if (CON_ALP.contains(c)) {
//                    writer.append(newChar(CON_ALP, key, c));
//                } else if (ALP.contains(c)) {
//                    writer.append(newChar(ALP, key, c));
//                } else {
//                    writer.append(c);
//                }
//            }
//        }
//    }
//}
//
//public static void decrypt(String file, int key) throws IOException {
//    String newFile = getNewFileName(file, "[DECRYPTED]");
//
//    try (BufferedReader reader = new BufferedReader(new FileReader(file));
//         BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
//
//        String s;
//        boolean isFirstLine = true;
//        while ((s = reader.readLine()) != null) {
//            if (!isFirstLine) {
//                writer.newLine(); // Додаємо новий рядок лише після першого рядка
//            }
//            isFirstLine = false;
//
//            char[] chars = s.toCharArray();
//            for (char c : chars) {
//                if (CON_ALP.contains(c)) {
//                    writer.append(newChar(CON_ALP, -key, c));
//                } else if (ALP.contains(c)) {
//                    writer.append(newChar(ALP, -key, c));
//                } else {
//                    writer.append(c);
//                }
//            }
//        }
//    }
//}
//public static char newChar(ArrayList<Character> alp, int key, char c) {
//    int index = alp.indexOf(c);
//    int sum = (index + key) % alp.size();
//
//    if (sum < 0) {
//        sum += alp.size();
//    }
//
//    return alp.get(sum);
//}