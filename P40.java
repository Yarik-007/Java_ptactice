//================================================================================//
//Байтовые и символьные потоки ввода/вывода
//================================================================================//
//Задача 1
//================================================================================//

// InputStream и метод read()

import java.io.*;
import java.util.Arrays;

public class InputStreamDemo {
    public static void main(String[] args) {

        System.out.println("=== InputStream: метод read() ===\n");

        // Используем ByteArrayInputStream (подкласс InputStream)
        byte[] data = {65, 66, 67, 68, 69}; // A, B, C, D, E

        try (ByteArrayInputStream bais = new ByteArrayInputStream(data)) {

            // read() - читает один байт (возвращает int от 0 до 255, или -1 если конец)
            int byte1 = bais.read();
            int byte2 = bais.read();

            System.out.println("Прочитанные байты: " + byte1 + ", " + byte2);
            System.out.println("Как символы: " + (char)byte1 + ", " + (char)byte2);

            // read(byte[] buffer) - читает массив байтов
            byte[] buffer = new byte[3];
            int count = bais.read(buffer);

            System.out.println("Прочитано байт: " + count);
            System.out.println("Содержимое буфера: " + Arrays.toString(buffer));
            System.out.println("Как строка: " + new String(buffer));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 

//================================================================================//
//Задача 2
//================================================================================//

// OutputStream и метод write(int)

import java.io.*;

public class OutputStreamDemo {
    public static void main(String[] args) {

        System.out.println("=== OutputStream: метод write(int) ===\n");

        // Используем ByteArrayOutputStream (подкласс OutputStream)
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            // write(int) - записывает один байт (младшие 8 бит)
            baos.write(65); // 'A'
            baos.write(66); // 'B'
            baos.write(67); // 'C'

            // write(byte[] buffer) - записывает массив байтов
            byte[] moreData = {68, 69, 70}; // D, E, F
            baos.write(moreData);

            // Получаем результат
            byte[] result = baos.toByteArray();
            System.out.println("Записанные байты: " + java.util.Arrays.toString(result));
            System.out.println("Как строка: " + new String(result));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

 

//================================================================================//
//Задача 3
//================================================================================//
// Зачем нужны Reader и Writer?

/*
Ответ:

InputStream/OutputStream работают с БАЙТАМИ (8 бит).
Reader/Writer работают с СИМВОЛАМИ (16 бит, Unicode).

Проблема байтовых потоков:
- При чтении текста нужно учитывать кодировку (UTF-8, Windows-1251 и т.д.)
- Один символ может занимать 1, 2 или более байт
- При побайтовом чтении русские буквы превращаются в "кракозябры"

Решение:
- Reader/Writer автоматически обрабатывают кодировки
- Работают с символами напрямую (char)
- Удобны для текстовых данных

Когда что использовать:
- Байтовые потоки - для картинок, аудио, видео, любых бинарных данных
- Символьные потоки - для текстовых файлов (UTF-8, UTF-16 и др.)
 */

//================================================================================//
//Задача 4
//================================================================================//
// Интерфейс AutoCloseable

import java.io.*;

public class AutoCloseableDemo {
    public static void main(String[] args) {

        System.out.println("=== AutoCloseable ===\n");

        System.out.println("Зачем нужен AutoCloseable?");
        System.out.println("- Позволяет автоматически закрывать ресурсы");
        System.out.println("- Работает с try-with-resources (Java 7+)");
        System.out.println("- Не нужно писать finally и close() вручную\n");

        // Пример 1: try-with-resources (ресурс закрывается автоматически)
        System.out.println("1. try-with-resources:");
        try (MyResource resource = new MyResource()) {
            resource.doSomething();
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Пример 2: несколько ресурсов
        System.out.println("\n2. Несколько ресурсов:");
        try (
                FileInputStream fis = new FileInputStream("file.txt");
                FileOutputStream fos = new FileOutputStream("output.txt")
        ) {
            // оба потока закроются автоматически
            System.out.println("   Ресурсы открыты");
        } catch (IOException e) {
            System.out.println("   Файл не найден (это нормально для примера)");
        }
    }
}

// Собственный класс с AutoCloseable
class MyResource implements AutoCloseable {

    public void doSomething() {
        System.out.println("   Выполнение операции с ресурсом");
    }

    @Override
    public void close() throws Exception {
        System.out.println("   Ресурс автоматически закрыт");
    }
}
 
