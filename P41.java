//================================================================================//
//Класс Scanner
//================================================================================//

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReadFileDemo {
    public static void main(String[] args) {

        System.out.println("=== Чтение файла с помощью Scanner ===\n");

        // Создаем тестовый файл (для примера)
        createTestFile();

        // Способ 1: Чтение всего файла построчно
        System.out.println("1. Чтение построчно:");
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("   " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        // Способ 2: Чтение с разделителями (по словам)
        System.out.println("\n2. Чтение по словам:");
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                System.out.println("   Слово: " + word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        // Способ 3: Чтение чисел из файла
        System.out.println("\n3. Чтение чисел:");
        try (Scanner scanner = new Scanner(new File("numbers.txt"))) {
            int sum = 0;
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                sum += num;
                System.out.println("   Число: " + num);
            }
            System.out.println("   Сумма: " + sum);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        // Способ 4: Чтение с указанием кодировки
        System.out.println("\n4. Чтение с кодировкой UTF-8:");
        try (Scanner scanner = new Scanner(new File("test.txt"), "UTF-8")) {
            String content = scanner.useDelimiter("\\Z").next();
            System.out.println("   " + content);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }

    static void createTestFile() {
        try (java.io.PrintWriter pw = new java.io.PrintWriter("test.txt")) {
            pw.println("Строка 1: Hello World");
            pw.println("Строка 2: Java Scanner");
            pw.println("Строка 3: Чтение файла");
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }

        try (java.io.PrintWriter pw = new java.io.PrintWriter("numbers.txt")) {
            pw.println("10 20 30");
            pw.println("40 50");
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
