package ua.com.javarush.gnew.JavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ua.com.javarush.gnew.runner.CipherApplication;

public class Controller {
    @FXML
    private TextField filePathField;

    @FXML
    private TextField helperFilePathField;

    @FXML
    private TextField keyField;

    @FXML
    private Button encryptButton, decryptButton, bruteForceButton, clearButton;

    @FXML
    private void handleEncrypt() {
        processAction("encrypt");
    }

    @FXML
    private void handleDecrypt() {
        processAction("decrypt");
    }

    @FXML
    private void handleBruteForce() {
        processAction("bruteforce");
    }

    @FXML
    private void handleClear() {
        filePathField.setText("");
        helperFilePathField.setText("");
        keyField.setText("");
    }

    private void processAction(String mode) {
        String filePath = filePathField.getText();
        String helperFilePath = helperFilePathField.getText();
        String key = keyField.getText();

        if (filePath.isEmpty()) {
            showError("Please specify the file path.");
            return;
        }

        try {
            CipherApplication app = CipherApplication.getInstance();
            if (mode.equals("encrypt")) {
                app.run(new String[]{"-e", "-f", filePath, "-k", key});
                showSuccess("File successfully encrypted.");
            } else if (mode.equals("decrypt")) {
                app.run(new String[]{"-d", "-f", filePath, "-k", key});
                showSuccess("File successfully decrypted.");
            } else if (mode.equals("bruteforce")) {
                if (helperFilePath.isEmpty()) {
                    app.run(new String[]{"-bf", "-f", filePath});
                } else {
                    app.run(new String[]{"-bf", "-f", filePath, "-fa", helperFilePath});
                }
                showSuccess("Brute force completed successfully.");
            }
        } catch (Exception e) {
            showError("An error occurred: " + e.getMessage());
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccess(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
