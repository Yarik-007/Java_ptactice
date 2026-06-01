import java.util.Scanner;

//Базовые типы данных и литералы
//Практика #4
public class Main {
    public static void main(String[] args) {
        String name = "Ярослав";
        for (char c : name.toCharArray()) {
            System.out.print("\\u" + String.format("%04X", (int) c));
        }
    }
}

/*
public class Main {
    public static void main(String[] args) {
        String text = "Результат: ";

        // String + примитивы
        System.out.println(text + 100);        // Результат: 100
        System.out.println(text + 3.14);       // Результат: 3.14
        System.out.println(text + true);       // Результат: true

        // Важно: порядок операций
        System.out.println(5 + 5 + " = сумма");   // 10 = сумма
        System.out.println("сумма = " + 5 + 5);   // сумма = 55
    }
}
 */
//Практика #5-6
/*
public class Main {
    void main() {
        byte a_byte = 121;
        int b_int = 9;
        double c_double = 3.12;
        Scanner in = new Scanner(System.in);
        System.out.println("a_byte = "+ a_byte+"\t"+"b_int = "+b_int+"\t"+"c_double = "+ c_double);
        System.out.println("summ = " + "a_byte + b_int" + " = " + (a_byte + b_int));
        System.out.println("summ = " + "c_double + b_int" + " = " + (c_double + b_int));
        System.out.println("composition = " + "c_double * b_int" + " = " + (c_double * b_int)+"\n");

        System.out.println("Приведем примеры с сужением преобразования типа переменной");
        System.out.println("summ = " + "a_byte + b_int" + " = (byte)(a_byte + b_int) " + (byte)(a_byte + b_int));
        System.out.println("composition = " + "a_byte * b_int" + " = (byte)(a_byte* b_int) = " + (byte)(a_byte* b_int)+"\n");

    }
}
 */
