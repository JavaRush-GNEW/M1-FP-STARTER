package ua.com.javarush.gnew.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ua.com.javarush.gnew.crypto.BruteForceResult;
import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.file.ChangeFileName;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private FileChooser fileChooser = new FileChooser();
    private ChangeFileName changeFileName = new ChangeFileName();
    private FileManager fileManager = new FileManager();
    private Cypher cypher = new Cypher();


    private String selectedPath;

    @FXML
    private Label actualPathLabel;

    @FXML
    private AnchorPane pane;

    @FXML
    private ComboBox<String> dropdown;

    @FXML
    private Button openNewFileDir;

    @FXML
    private Button choesePathButton;

    @FXML
    private TextField inputKey;

    @FXML
    private Button doCypherButton;

    @FXML
    private Label newFilePath;

    @FXML
    private Label status;

    @FXML
    void choeseButtonCliced(ActionEvent event) {
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        actualPathLabel.setText(selectedFile.toString());
    }

    @FXML
    void keyInputSelected(KeyEvent event) {
    }

    @FXML
    void doCypher(ActionEvent event) {
        boolean actualPathEmpty = actualPathLabel.getText().isEmpty();
        boolean dropdownEmpty = dropdown.getSelectionModel().isEmpty();

        if (!actualPathEmpty && !dropdownEmpty) {
            if (dropdown.getValue().equals("Encrypt")) {
                Command command = Command.ENCRYPT;
                Integer key = Integer.parseInt(inputKey.getText());
                Path filePath = Path.of(actualPathLabel.getText());
                selectedPath = actualPathLabel.getText();
                RunOptions runOptions = new RunOptions(command, key, filePath);
                String content = fileManager.read(runOptions.getFilePath());
                Path newFilePath = changeFileName.newFileName(runOptions, "ENCRYPTED");
                fileManager.write(newFilePath, cypher.encrypt(content, runOptions.getKey()));

            } else if (dropdown.getValue().equals("Decrypt")) {
                Command command = Command.DECRYPT;
                Integer key = Integer.parseInt(inputKey.getText());
                Path filePath = Path.of(actualPathLabel.getText());
                selectedPath = actualPathLabel.getText();
                RunOptions runOptions = new RunOptions(command, key, filePath);
                String content = fileManager.read(runOptions.getFilePath());
                Path newFilePath = changeFileName.newFileName(runOptions, "DECRYPTED");
                fileManager.write(newFilePath, cypher.decrypt(content, runOptions.getKey()));

            } else if (dropdown.getValue().equals("Bruteforce")) {
                Command command = Command.BRUTEFORCE;
                Integer key = Integer.parseInt(inputKey.getText());
                Path filePath = Path.of(actualPathLabel.getText());
                selectedPath = actualPathLabel.getText();
                RunOptions runOptions = new RunOptions(command, key, filePath);
                String content = fileManager.read(runOptions.getFilePath());
                BruteForceResult result = cypher.bruteforce(content);
                Path newFilePath = changeFileName.newFileNameWithKey(runOptions, "DECRYPTED", result.getKey());
                fileManager.write(newFilePath, result.getDecryptedContent());
            }
        } else {
            status.setText("Поля не заполнены");
        }
        actualPathLabel.setText("");
        status.setText("Done");

    }

    @FXML
    void methodChoesed(ActionEvent event) {
//        Выключение отображение поля "Key" если выбран брутфорс
        if (dropdown.getSelectionModel().getSelectedItem().equals("Bruteforce")) {
            inputKey.setVisible(false);
        } else {
            inputKey.setVisible(true);
        }
    }

    @FXML
    void newFileOpenPath(ActionEvent event) {
        File file = new File(selectedPath);
        try {
            Desktop.getDesktop().open(file.getParentFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void paneMouseClicked(MouseEvent event) {
        if (inputKey.isFocused()) {
            pane.requestFocus();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] items = {"Encrypt", "Decrypt", "Bruteforce"};
        dropdown.getItems().addAll(items);

        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Текстовые файлы", "*.txt"));
        fileChooser.setInitialDirectory(new File("C:\\Users\\evgen\\Desktop"));
    }
}
