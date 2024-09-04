package ua.com.javarush.gnew.runner;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ArgumentsParser {
    public RunOptions parse() {
        Scanner input = new Scanner(System.in);
        Command command;
        Integer key = null;
        Path filePath ;

        System.out.println("Введите команду (e - encrypt, d - decrypt, bf - bruteforce):");
        String commandInput = input.nextLine().trim();

        if (commandInput.equalsIgnoreCase("e")) {
            command = Command.ENCRYPT;
        } else if (commandInput.equalsIgnoreCase("d")) {
            command = Command.DECRYPT;
        } else if (commandInput.equalsIgnoreCase("bf")) {
            command = Command.BRUTEFORCE;
        } else {
            throw new IllegalArgumentException("Неизвестная команда. Ожидалась команда (e, d, или bf)");
        }


        if (command == Command.ENCRYPT || command == Command.DECRYPT) {
            System.out.println("Введите ключ для шифрования/дешифрования:");
            key = Integer.parseInt(input.nextLine().trim());
        }

        System.out.println("Введите путь к файлу:");
        String filePathInput = input.nextLine().trim();
        filePath = Paths.get(filePathInput);

        return new RunOptions(command, key, filePath);
    }
}
