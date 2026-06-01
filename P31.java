//================================================================================//
// Класс String
//================================================================================//
// Задача 1
//================================================================================//

// Демонстрация 10 методов класса String

public class StringMethodsDemo {
    public static void main(String[] args) {

        System.out.println("=== 10 методов класса String ===\n");

        String str = "   Hello, World!   ";
        String str2 = "Hello, Java";

        // 1. length() - возвращает длину строки
        System.out.println("1. length(): " + str.length()); // 19 (с пробелами)

        // 2. trim() - удаляет пробелы в начале и конце строки
        System.out.println("2. trim(): '" + str.trim() + "'"); // 'Hello, World!'

        // 3. toUpperCase() / toLowerCase() - преобразование регистра
        System.out.println("3. toUpperCase(): " + str.toUpperCase());
        System.out.println("   toLowerCase(): " + str.toLowerCase());

        // 4. charAt() - возвращает символ по индексу
        System.out.println("4. charAt(7): " + str.charAt(7)); // 'o'

        // 5. substring() - извлекает подстроку
        System.out.println("5. substring(5, 10): '" + str.substring(5, 10) + "'"); // 'o, Wo'

        // 6. contains() - проверяет наличие подстроки
        System.out.println("6. contains('World'): " + str.contains("World")); // true

        // 7. replace() - заменяет символы или подстроки
        System.out.println("7. replace('o', '0'): " + str.replace('o', '0'));

        // 8. split() - разделяет строку на массив
        System.out.print("8. split(', '): ");
        String[] parts = str.trim().split(", ");
        for (String part : parts) {
            System.out.print("[" + part + "] ");
        }
        System.out.println();

        // 9. equals() / equalsIgnoreCase() - сравнение строк
        System.out.println("9. equals('hello, world!'): " + str.trim().equals("hello, world!")); // false
        System.out.println("   equalsIgnoreCase(): " + str.trim().equalsIgnoreCase("hello, world!")); // true

        // 10. startsWith() / endsWith() - проверка начала и конца строки
        System.out.println("10. startsWith('   He'): " + str.startsWith("   He")); // true
        System.out.println("    endsWith('!   '): " + str.endsWith("!   ")); // true

        // Дополнительные полезные методы
        System.out.println("\n=== Дополнительные методы ===");

        // isEmpty() / isBlank() - проверка на пустоту
        String empty = "   ";
        System.out.println("isEmpty(): " + empty.isEmpty());   // false
        System.out.println("isBlank(): " + empty.isBlank());   // true (Java 11+)

        // join() - объединение строк
        String joined = String.join("-", "apple", "banana", "orange");
        System.out.println("join(): " + joined); // apple-banana-orange

        // repeat() - повторение строки (Java 11+)
        System.out.println("repeat(): " + "Hi! ".repeat(3)); // Hi! Hi! Hi!

        // indent() - добавление отступов (Java 13+)
        System.out.println("indent(): \n" + "Text".indent(4));
    }
}
 

//================================================================================//
// Задача 2
//================================================================================//

// Примеры использования StringJoiner

import java.util.StringJoiner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringJoinerDemo {
    public static void main(String[] args) {

        System.out.println("=== Примеры StringJoiner ===\n");

        // Пример 1: Простое объединение с разделителем
        System.out.println("1. Базовое объединение:");
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("Яблоко");
        joiner1.add("Банан");
        joiner1.add("Апельсин");
        System.out.println(joiner1); // Яблоко, Банан, Апельсин

        // Пример 2: С префиксом и суффиксом
        System.out.println("\n2. С префиксом и суффиксом:");
        StringJoiner joiner2 = new StringJoiner(", ", "[", "]");
        joiner2.add("Красный");
        joiner2.add("Синий");
        joiner2.add("Зеленый");
        System.out.println(joiner2); // [Красный, Синий, Зеленый]

        // Пример 3: Объединение двух StringJoiner
        System.out.println("\n3. Объединение двух StringJoiner:");
        StringJoiner fruits = new StringJoiner(", ");
        fruits.add("Яблоко").add("Груша");

        StringJoiner vegetables = new StringJoiner(", ");
        vegetables.add("Морковь").add("Картофель");

        fruits.merge(vegetables);
        System.out.println(fruits); // Яблоко, Груша, Морковь, Картофель

        // Пример 4: Пустой StringJoiner
        System.out.println("\n4. Пустой StringJoiner:");
        StringJoiner empty = new StringJoiner(", ", "{", "}");
        System.out.println("Пустой: " + empty); // {}

        // Пример 5: С коллекцией
        System.out.println("\n5. Использование с коллекцией:");
        List<String> names = Arrays.asList("Анна", "Мария", "Елена");
        StringJoiner nameJoiner = new StringJoiner(" | ", "Имена: ", "");
        for (String name : names) {
            nameJoiner.add(name);
        }
        System.out.println(nameJoiner); // Имена: Анна | Мария | Елена

        // Пример 6: Альтернатива - Collectors.joining()
        System.out.println("\n6. Через Stream API:");
        String result = Arrays.asList("один", "два", "три")
            .stream()
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(result); // [один, два, три]

        // Пример 7: setEmptyValue() - значение для пустого Joiner
        System.out.println("\n7. setEmptyValue():");
        StringJoiner joiner3 = new StringJoiner(", ");
        joiner3.setEmptyValue("Нет элементов");
        System.out.println(joiner3); // Нет элементов
        joiner3.add("Элемент");
        System.out.println(joiner3); // Элемент
    }
}
 
//================================================================================//
// Задача 3
//================================================================================//

// Три двойные кавычки (Text Blocks) - многострочные строки (Java 13+)

public class TextBlockDemo {
    public static void main(String[] args) {

        System.out.println("=== Три двойные кавычки (Text Blocks) ===\n");

        // Старый способ (до Java 13)
        System.out.println("1. Старый способ (экранирование и конкатенация):");
        String oldWay = "{\n" +
                        "  \"name\": \"Иван\",\n" +
                        "  \"age\": 30\n" +
                        "}";
        System.out.println(oldWay);

        // Новый способ - Text Block (три двойные кавычки)
        System.out.println("\n2. Text Block (три двойные кавычки):");
        String textBlock = """
                {
                  "name": "Иван",
                  "age": 30
                }
                """;
        System.out.println(textBlock);

        // Сохранение форматирования (пробелы и переносы строк)
        System.out.println("\n3. Сохранение форматирования:");
        String sql = """
                SELECT id, name, email
                FROM users
                WHERE active = true
                ORDER BY name
                """;
        System.out.println(sql);

        // Экранирование в text block
        System.out.println("\n4. Экранирование кавычек:");
        String html = """
                <div class="container">
                    <p>Hello "World"</p>
                </div>
                """;
        System.out.println(html);

        // Использование \s для сохранения пробелов в конце строки
        System.out.println("\n5. Сохранение пробелов в конце строки:");
        String withSpaces = """
                Слово с пробелами в конце:\s\s\s
                Следующая строка
                """;
        System.out.println(withSpaces);

        // Отступы: лидирующие пробелы автоматически обрезаются
        System.out.println("\n6. Автоматическое удаление общих отступов:");
        String indented = """
                          Строка 1
                          Строка 2
                          Строка 3
                          """;
        System.out.println(indented);

        // Для чего нужны три двойные кавычки:
        System.out.println("\n=== Зачем нужны три двойные кавычки? ===");
        System.out.println("1. Удобное написание многострочного текста (JSON, HTML, SQL, XML)");
        System.out.println("2. Не нужны экранирование кавычек и переносов строк");
        System.out.println("3. Сохраняется читаемость форматирования");
        System.out.println("4. Автоматическое удаление общих отступов");
        System.out.println("5. Меньше ошибок с escape-последовательностями");

        // Сравнение
        System.out.println("\n=== Сравнение подходов ===");
        System.out.println("Без text block:");
        System.out.println("String json = \"{\\n  \\\"name\\\": \\\"Иван\\\"\\n}\";");
        System.out.println("\nС text block:");
        System.out.println("""
                String json = \"\"\"
                        {
                          "name": "Иван"
                        }
                        \"\"\";
                """);
    }
}
