package ua.com.javarush.gnew.Constants;

import java.util.ArrayList;
import java.util.Arrays;

    public class Constants {
        private static ArrayList<Character> ENG_LOWER = new ArrayList<>(Arrays.asList(
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        private static ArrayList<Character> ENG_UPPER = new ArrayList<>(Arrays.asList(
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
        private static ArrayList<Character> UKR_LOWER = new ArrayList<>(Arrays.asList(
                'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я'));
        private static ArrayList<Character> UKR_UPPER = new ArrayList<>(Arrays.asList(
                'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я'));

        public ArrayList<Character> getEngLower(){
            return ENG_LOWER;
        }
        public void setEngLower(ArrayList<Character> ENG_LOWER){
            Constants.ENG_LOWER = ENG_LOWER;
        }
        public ArrayList<Character> getEngUpper(){
            return ENG_UPPER;
        }
        public void setEngUpper(ArrayList<Character> ENG_UPPER){
            Constants.ENG_UPPER = ENG_UPPER;
        }
        public ArrayList<Character> getUkrLower(){
            return UKR_LOWER;
        }
        public void setUkrLower(ArrayList<Character> UKR_LOWER){
            Constants.UKR_LOWER = UKR_LOWER;
        }
        public ArrayList<Character> getUkrUpper(){
            return UKR_UPPER;
        }
        public void setUkrUpper(ArrayList<Character> UKR_UPPER){
            Constants.UKR_UPPER = UKR_UPPER;
        }
    }


