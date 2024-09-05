package ua.com.javarush.gnew;


import ua.com.javarush.gnew.runner.Runner;



public class Main {

    public static void main(String[] args) {
        Runner.getRunner().run(args);
        Runner.getRunner().runWithConsol();
    }
}