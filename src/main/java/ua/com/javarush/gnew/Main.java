package ua.com.javarush.gnew;

import ua.com.javarush.gnew.processing.ArgumentParser;
import ua.com.javarush.gnew.processing.CryptoOperationHandler;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided. Use -e for encrypt, -d for decrypt, -k for key, -bf for brute-force, -p for file path.");
            return;
        }

        try {
            ArgumentParser parser = new ArgumentParser(args);
            CryptoOperationHandler handler = new CryptoOperationHandler();
            handler.handleOperation(parser.getMode(), parser.getFilePath(), parser.getKey(), parser.isBruteForce());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

