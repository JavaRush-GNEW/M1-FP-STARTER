package ua.com.javarush.gnew.CLI;

import ua.com.javarush.gnew.Dictionary.Dictionary;
import ua.com.javarush.gnew.crypt.code.Cryptanalyzer;
import ua.com.javarush.gnew.crypt.code.RunBruteforce;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.runner.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Path;

public class CryptAnalyzerGUI {
    private static final Cryptanalyzer cryptanalyzer = new Cryptanalyzer();
    private static final RunBruteforce runBruteforce = new RunBruteforce();
    private static final FileManager fileManager = new FileManager();
    private static final Dictionary dictionary = new Dictionary();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cryptanalyzer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel commandLabel = new JLabel("Выберите команду:");
        panel.add(commandLabel);

        String[] commands = {"ENCRYPT", "DECRYPT", "BRUTEFORCE"};
        JComboBox<String> commandBox = new JComboBox<>(commands);
        panel.add(commandBox);

        JLabel fileLabel = new JLabel("Выберите файл:");
        JTextField filePathField = new JTextField(20);
        JButton fileButton = new JButton("Выбрать файл");
        fileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                filePathField.setText(fileChooser.getSelectedFile().getPath());
            }
        });

        JPanel filePanel = new JPanel();
        filePanel.add(filePathField);
        filePanel.add(fileButton);
        panel.add(fileLabel);
        panel.add(filePanel);

        JLabel keyLabel = new JLabel("Введите ключ (только для ENCRYPT и DECRYPT):");
        JTextField keyField = new JTextField(10);
        panel.add(keyLabel);
        panel.add(keyField);

        JButton executeButton = new JButton("Выполнить");
        panel.add(executeButton);

        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        executeButton.addActionListener((ActionEvent e) -> {
            try {
                String selectedCommand = (String) commandBox.getSelectedItem();
                Path filePath = Path.of(filePathField.getText());
                String content = fileManager.read(filePath);

                if (selectedCommand.equals("ENCRYPT")) {
                    int key = Integer.parseInt(keyField.getText());
                    String encryptedContent = cryptanalyzer.encryption(content, key);
                    String newFileName = filePath.getFileName().toString().replace(".txt", " [ENCRYPTED].txt");
                    Path newFilePath = filePath.resolveSibling(newFileName);
                    fileManager.write(newFilePath, encryptedContent);
                    resultArea.setText("Файл успешно зашифрован: " + newFilePath);
                } else if (selectedCommand.equals("DECRYPT")) {
                    int key = Integer.parseInt(keyField.getText());
                    String decryptedContent = cryptanalyzer.decryption(content, key);
                    String newFileName = filePath.getFileName().toString().replace(".txt", " [DECRYPTED].txt");
                    Path newFilePath = filePath.resolveSibling(newFileName);
                    fileManager.write(newFilePath, decryptedContent);
                    resultArea.setText("Файл успешно расшифрован: " + newFilePath);
                } else if (selectedCommand.equals("BRUTEFORCE")) {
                    String decryptedContent = runBruteforce.bruteforce(content, dictionary.getDictionary(), dictionary.getDictionaryUKR());
                    String key = runBruteforce.getKey(content, dictionary.getDictionary(), dictionary.getDictionaryUKR()).replace("Key: ", "");
                    String newFileName = filePath.getFileName().toString().replace(".txt", " [DECRYPTED Key-" + key + "].txt");
                    Path newFilePath = filePath.resolveSibling(newFileName);
                    fileManager.write(newFilePath, decryptedContent);
                    resultArea.setText("Брутфорс выполнен. Найден ключ: " + key + "\nФайл сохранен как: " + newFilePath);
                }
            } catch (IOException ex) {
                resultArea.setText("Ошибка чтения/записи файла: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                resultArea.setText("Неправильный формат ключа: " + ex.getMessage());
            } catch (Exception ex) {
                resultArea.setText("Произошла ошибка: " + ex.getMessage());
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}

