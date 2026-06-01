//================================================================================//
//Форматирование информации
//================================================================================//
//Задачи 1 и 3
//================================================================================//

// Примеры использования спецификаторов форматирования (форматтеров) в Java

import java.util.Date;
import java.util.Locale;

public class FormatSpecifiersDemo {
    public static void main(String[] args) {

        System.out.println("=== Спецификаторы форматирования в Java ===\n");

        // 1. %d - целые числа (десятичные)
        System.out.println("1. %d - целые числа:");
        System.out.printf("   int: %d%n", 100);
        System.out.printf("   с шириной 5: %5d%n", 100);
        System.out.printf("   с ведущими нулями: %05d%n", 100);
        System.out.printf("   отрицательное: %d%n", -50);

        // 2. %f - числа с плавающей точкой
        System.out.println("\n2. %f - числа с плавающей точкой:");
        System.out.printf("   double: %f%n", 3.14159);
        System.out.printf("   с 2 знаками: %.2f%n", 3.14159);
        System.out.printf("   ширина 8: %8.2f%n", 3.14159);
        System.out.printf("   с запятой: %,.2f%n", 1234567.89);

        // 3. %s - строки
        System.out.println("\n3. %s - строки:");
        System.out.printf("   строка: %s%n", "Hello");
        System.out.printf("   с шириной 10: %10s%n", "Hello");
        System.out.printf("   выравнивание влево: %-10s!%n", "Hello");
        System.out.printf("   преобразование в верхний регистр: %S%n", "hello");

        // 4. %c - символы
        System.out.println("\n4. %c - символы:");
        System.out.printf("   символ: %c%n", 'A');
        System.out.printf("   код символа: %c%n", 65);  // A
        System.out.printf("   ширина 3: %3c%n", 'B');

        // 5. %b - булевы значения
        System.out.println("\n5. %b - булевы значения:");
        System.out.printf("   true: %b%n", true);
        System.out.printf("   false: %b%n", false);
        System.out.printf("   null: %b%n", null);
        System.out.printf("   число 0: %b%n", 0);  // true (только null дает false)

        // 6. %x / %X - шестнадцатеричные числа
        System.out.println("\n6. %x/%X - шестнадцатеричные:");
        System.out.printf("   hex: %x%n", 255);
        System.out.printf("   HEX верхний: %X%n", 255);
        System.out.printf("   с префиксом: %#x%n", 255);

        // 7. %o - восьмеричные числа
        System.out.println("\n7. %o - восьмеричные:");
        System.out.printf("   octal: %o%n", 64);
        System.out.printf("   с префиксом: %#o%n", 64);

        // 8. %e / %E - экспоненциальная форма
        System.out.println("\n8. %e - экспоненциальная форма:");
        System.out.printf("   exp: %e%n", 12345.6789);
        System.out.printf("   с 2 знаками: %.2e%n", 12345.6789);

        // 9. %t - дата и время
        System.out.println("\n9. %t - дата и время:");
        Date now = new Date();
        System.out.printf("   время: %tT%n", now);
        System.out.printf("   дата: %tD%n", now);
        System.out.printf("   месяц: %tB%n", now);

        // 10. %n - платформо-независимый перевод строки
        System.out.println("\n10. %n - перевод строки:");
        System.out.printf("   Строка 1%n   Строка 2%n");

        // Дополнительные примеры комбинирования
        System.out.println("\n=== Комбинирование спецификаторов ===");
        System.out.printf("Имя: %s, Возраст: %d, Рост: %.2f%n", "Иван", 25, 1.75);

        // Индексы аргументов
        System.out.println("\n=== Индексы аргументов ===");
        System.out.printf("%2$s, %1$s!%n", "Мир", "Привет");

        // Локализация
        System.out.println("\n=== Локализация ===");
        System.out.printf(Locale.US, "US: %,.2f%n", 12345.67);
        System.out.printf(Locale.GERMANY, "Germany: %,.2f%n", 12345.67);
    }
}
 

//================================================================================//
//Задача 2
//================================================================================//

// Зачем нужен метод flush()

import java.io.*;

public class FlushMethodDemo {
    public static void main(String[] args) {

        System.out.println("=== Метод flush() - зачем нужен ===\n");

        System.out.println("Что делает flush():");
        System.out.println("- Принудительно записывает данные из буфера в целевое устройство");
        System.out.println("- Очищает буфер вывода");
        System.out.println("- Гарантирует, что данные действительно записаны\n");

        System.out.println("Когда используется:");
        System.out.println("- При работе с файлами, сетью, консолью");
        System.out.println("- Когда важна немедленная запись данных");
        System.out.println("- Перед закрытием потока");
        System.out.println("- В критических секциях, где данные должны быть сохранены\n");

        // Пример 1: Без flush() - данные могут остаться в буфере
        System.out.println("Пример 1: Запись в файл без flush():");
        try (FileWriter fw = new FileWriter("test.txt")) {
            fw.write("Эта строка может остаться в буфере");
            // fw.flush(); // Если закомментировать, данные могут не записаться при ошибке
            System.out.println("   Данные записаны (возможно, только в буфер)");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Пример 2: С flush() - данные записываются немедленно
        System.out.println("\nПример 2: Запись в файл с flush():");
        try (FileWriter fw = new FileWriter("test2.txt")) {
            fw.write("Эта строка записана немедленно");
            fw.flush(); // Принудительная запись
            System.out.println("   Данные гарантированно записаны на диск");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Пример 3: Буферизированный поток
        System.out.println("\nПример 3: BufferedWriter требует flush():");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("test3.txt"))) {
            bw.write("Буферизированный текст");
            bw.newLine();
            bw.write("Еще одна строка");
            bw.flush(); // Без flush() данные могут не записаться
            System.out.println("   Буфер очищен, данные записаны");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Пример 4: PrintWriter с autoFlush
        System.out.println("\nПример 4: PrintWriter с autoFlush:");
        try (PrintWriter pw = new PrintWriter(new FileWriter("test4.txt"), true)) {
            pw.println("Эта строка будет записана автоматически");
            System.out.println("   Auto-flush включен (println вызывает flush)");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Пример 5: Консольный вывод
        System.out.println("\nПример 5: System.out.flush():");
        System.out.print("Текст без перевода строки");
        System.out.flush(); // Принудительный вывод на консоль
        System.out.println(" - после flush");

        System.out.println("\n=== Итог ===");
        System.out.println("flush() нужен для:");
        System.out.println("1. Гарантии записи данных при обрыве программы");
        System.out.println("2. Немедленного отображения данных (чат, логгеры)");
        System.out.println("3. Освобождения буфера при работе с большими объемами");
        System.out.println("4. В сетевом программировании для отправки пакетов");
        System.out.println("5. При работе с потоками, где важна синхронизация");
    }
}
