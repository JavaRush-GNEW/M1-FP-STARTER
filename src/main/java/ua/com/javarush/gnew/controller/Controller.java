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

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private final FileChooser fileChooser = new FileChooser();
    private final ChangeFileName changeFileName = new ChangeFileName();
    private final FileManager fileManager = new FileManager();
    private final Cypher cypher = new Cypher();
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
        if (selectedFile != null) {
            updatePathLabel(selectedFile.toString());
            updateUIForSelectedCommand();
            openNewFileDir.setDisable(true);
        }
    }

    private void updatePathLabel(String path) {
        actualPathLabel.setText(path);
    }

    private void updateUIForSelectedCommand() {
        String selectedCommand = dropdown.getValue();
        if ("Encrypt".equals(selectedCommand) || "Decrypt".equals(selectedCommand)) {
            inputKey.setDisable(false);
        } else if ("Bruteforce".equals(selectedCommand)) {
            doCypherButton.setDisable(false);
        }
    }

    @FXML
    void keyInputSelected(KeyEvent event) {
        if (inputKey.isFocused()) {
            doCypherButton.setDisable(false);
        }
    }

    @FXML
    void doCypher(ActionEvent event) {
        if (isFormValid()) {
            try {
                processCommand();
                resetUIAfterProcessing();
            } catch (IOException e) {
                status.setText("Произошла ошибка: " + e.getMessage());
            }
        } else {
            status.setText("Поля не заполнены");
        }
    }

    private boolean isFormValid() {
        return !actualPathLabel.getText().isEmpty() && !dropdown.getSelectionModel().isEmpty();
    }

    private void processCommand() throws IOException {
        String selectedCommand = dropdown.getValue();
        Integer key = getKey();
        Path filePath = Path.of(actualPathLabel.getText());
        selectedPath = actualPathLabel.getText();
        RunOptions runOptions = new RunOptions(getCommand(selectedCommand), key, filePath);
        String content = fileManager.read(runOptions.getFilePath());

        if ("Encrypt".equals(selectedCommand)) {
            writeToFile(changeFileName.newFileName(runOptions, "ENCRYPTED"), cypher.encrypt(content, runOptions.getKey()));
        } else if ("Decrypt".equals(selectedCommand)) {
            writeToFile(changeFileName.newFileName(runOptions, "DECRYPTED"), cypher.decrypt(content, runOptions.getKey()));
        } else if ("Bruteforce".equals(selectedCommand)) {
            BruteForceResult result = cypher.bruteforce(content);
            writeToFile(changeFileName.newFileNameWithKey(runOptions, "DECRYPTED", result.getKey()), result.getDecryptedContent());
        }
    }

    private Command getCommand(String command) {
        return switch (command) {
            case "Encrypt" -> Command.ENCRYPT;
            case "Decrypt" -> Command.DECRYPT;
            case "Bruteforce" -> Command.BRUTEFORCE;
            default -> throw new IllegalArgumentException("Unknown command: " + command);
        };
    }

    private Integer getKey() {
        return "Bruteforce".equals(dropdown.getValue()) ? 0 : Integer.parseInt(inputKey.getText());
    }

    private void writeToFile(Path filePath, String content) throws IOException {
        fileManager.write(filePath, content);
    }

    private void resetUIAfterProcessing() {
        inputKey.clear();
        inputKey.setDisable(true);
        doCypherButton.setDisable(true);
        openNewFileDir.setDisable(false);
        actualPathLabel.setText("");
        status.setText("Done");
    }

    @FXML
    void methodChoesed (ActionEvent event) {
        choesePathButton.setDisable(false);
        inputKey.setVisible(!"Bruteforce".equals(dropdown.getSelectionModel().getSelectedItem()));
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
        dropdown.getItems().addAll("Encrypt", "Decrypt", "Bruteforce");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Текстовые файлы", "*.txt"));
        fileChooser.setInitialDirectory(new File("C:\\Users\\evgen\\Desktop"));
    }
}
