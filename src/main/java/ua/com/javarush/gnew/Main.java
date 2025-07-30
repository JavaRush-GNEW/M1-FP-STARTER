package ua.com.javarush.gnew;

import ua.com.javarush.gnew.runner.AppRunner;
import ua.com.javarush.gnew.ui.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));

        try{
            new AppRunner().run(args);
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}