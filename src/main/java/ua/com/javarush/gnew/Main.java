package ua.com.javarush.gnew;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ua.com.javarush.gnew.crypto.BruteForceResult;
import ua.com.javarush.gnew.crypto.Cypher;
import ua.com.javarush.gnew.exeptions.FileNotFoundException;
import ua.com.javarush.gnew.file.ChangeFileName;
import ua.com.javarush.gnew.file.FileManager;
import ua.com.javarush.gnew.runner.ArgumentsParser;
import ua.com.javarush.gnew.runner.Command;
import ua.com.javarush.gnew.runner.RunOptions;

import java.io.IOException;
import java.nio.file.Path;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("UI.fxml"));
        primaryStage.setTitle("Caesar Cipher");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static Cypher cypher = new Cypher();
    public static FileManager fileManager = new FileManager();
    public static ArgumentsParser argumentsParser = new ArgumentsParser();
    public static ChangeFileName changeFileName = new ChangeFileName();

    public static void main(String[] args) {

        if (args.length == 0) {
            launch();
        }
        try {
            RunOptions runOptions = argumentsParser.parse(args);
            String content = fileManager.read(runOptions.getFilePath());

            if (runOptions.getCommand() == Command.ENCRYPT) {

                Path newFilePath = changeFileName.newFileName(runOptions, "ENCRYPTED");
                fileManager.write(newFilePath, cypher.encrypt(content, runOptions.getKey()));
            } else if (runOptions.getCommand() == Command.DECRYPT) {

                Path newFilePath = changeFileName.newFileName(runOptions, "DECRYPTED");
                fileManager.write(newFilePath, cypher.decrypt(content, runOptions.getKey()));
            } else if (runOptions.getCommand() == Command.BRUTEFORCE) {

                BruteForceResult result = cypher.bruteforce(content);
                Path newFilePath = changeFileName.newFileNameWithKey(runOptions, "BRUTEFORCED", result.getKey());
                fileManager.write(newFilePath, result.getDecryptedContent());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}















