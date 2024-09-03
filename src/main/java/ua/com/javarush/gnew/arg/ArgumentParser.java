package ua.com.javarush.gnew.arg;

public class ArgumentParser {

    public static Arguments parse(String[] args) {
        String mode = null;
        String file = null;
        int key = 0;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-e":
                    mode = "-e";
                    break;
                case "-d":
                    mode = "-d";
                    break;
                case "-bf":
                    mode = "-bf";
                    break;
                case "-k":
                    key = Integer.parseInt(args[++i]);
                    break;
                case "-f":
                    file = args[++i];
                    break;
                default:
                    throw new IllegalArgumentException("Unknown argument: " + args[i]);
            }
        }

        if (file == null || mode == null) {
            throw new IllegalArgumentException("File or mode not specified. Use '-e' for encryption, '-d' for decryption, or '-bf' for brute force.");
        }

        return new Arguments(mode, file, key);
    }
}