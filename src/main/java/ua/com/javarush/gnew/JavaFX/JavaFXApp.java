package ua.com.javarush.gnew.JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        primaryStage.setTitle("Cipher Application");
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Application closed");
        });

        primaryStage.show();
    }

    public static void launchApp(String[] args) {
        Application.launch(args);
    }
}

