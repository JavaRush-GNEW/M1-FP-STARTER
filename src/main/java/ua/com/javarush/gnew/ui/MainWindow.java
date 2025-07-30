package ua.com.javarush.gnew.ui;

import ua.com.javarush.gnew.runner.AppRunner;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

public class MainWindow extends JFrame {
    private JComboBox<String> commandBox;
    private JTextField keyField;
    private JTextField fileField;
    private JTextArea resultArea;

    public MainWindow() {
        setTitle("Crypto App");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        topPanel.add(new JLabel("File path:"));
        fileField = new JTextField();
        topPanel.add(fileField);

        topPanel.add(new JLabel("Command:"));
        commandBox = new JComboBox<>(new String[]{"Encrypt", "Decrypt", "Bruteforce"});
        topPanel.add(commandBox);

        topPanel.add(new JLabel("Key (for encrypt/decrypt):"));
        keyField = new JTextField();
        topPanel.add(keyField);

        add(topPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        JButton executeButton = new JButton("Execute");
        add(executeButton, BorderLayout.SOUTH);

        executeButton.addActionListener(e -> {
            try {
                String commandStr = (String) commandBox.getSelectedItem();
                String filePathStr = fileField.getText().trim();
                String keyStr = keyField.getText().trim();

                Command command = Command.valueOf(commandStr.toUpperCase());
                Path filePath = Path.of(filePathStr);
                Integer key = (command == Command.BRUTEFORCE) ? null : Integer.parseInt(keyStr);

                RunOptions runOptions = new RunOptions(command, key, filePath);
                AppRunner runner = new AppRunner();
                runner.runWithOptions(runOptions);

                resultArea.setText("Done! Check the output file in the same folder.");
            } catch (Exception ex) {
                resultArea.setText("Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }
}
