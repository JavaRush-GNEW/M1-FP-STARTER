package ua.com.javarush.gnew;


import ua.com.javarush.gnew.JavaFX.JavaFXApp;
import ua.com.javarush.gnew.runner.CipherApplication;



public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            JavaFXApp.launchApp(args);
        } else {
            CipherApplication app = CipherApplication.getInstance();
            app.run(args);
            app.runInteractive();
        }
    }
}