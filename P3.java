import java.util.Scanner;

//Базовые типы данных и литералы

public class Main {
    public static void main(String[] args) {
        String name = "Ярослав";
        for (char c : name.toCharArray()) {
            System.out.print("\\u" + String.format("%04X", (int) c));
        }
    }
}

