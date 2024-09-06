package ua.com.javarush.gnew;


import ua.com.javarush.gnew.runner.CipherApplication;



public class Main {

    public static void main(String[] args) {
        CipherApplication app = CipherApplication.getInstance();
        app.run(args);
        app.runInteractive();
    }
}