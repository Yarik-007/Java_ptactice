//================================================================================//
//Иерархия исключений и ошибок
//================================================================================//
//Задачи 1
//================================================================================//

// Назначение основных классов исключений

public class ExceptionsPurposeDemo {
    public static void main(String[] args) {

        System.out.println("=== Назначение основных классов исключений ===\n");

        System.out.println("1. ArithmeticException:");
        System.out.println("   - Возникает при арифметических ошибках");
        System.out.println("   - Пример: деление на ноль\n");

        System.out.println("2. ArrayIndexOutOfBoundsException:");
        System.out.println("   - Возникает при обращении к несуществующему индексу массива");
        System.out.println("   - Пример: arr[5] при длине массива 3\n");

        System.out.println("3. IllegalArgumentException:");
        System.out.println("   - Бросается при передаче некорректных аргументов методу");
        System.out.println("   - Пример: отрицательный возраст, null в параметре\n");

        System.out.println("4. ClassCastException:");
        System.out.println("   - Возникает при некорректном приведении типов");
        System.out.println("   - Пример: (String) object, где object - Integer\n");

        System.out.println("5. NullPointerException:");
        System.out.println("   - Самое частое исключение");
        System.out.println("   - Возникает при вызове метода на null ссылке\n");

        System.out.println("6. NumberFormatException:");
        System.out.println("   - При преобразовании строки в число (нечисловой формат)");
        System.out.println("   - Пример: Integer.parseInt(\"abc\")\n");

        System.out.println("7. IOException:");
        System.out.println("   - Ошибки ввода-вывода");
        System.out.println("   - Пример: файл не найден, ошибка чтения\n");

        System.out.println("8. SQLException:");
        System.out.println("   - Ошибки при работе с базами данных\n");
    }
}
 
//================================================================================//
//Задачи 2
//================================================================================//

// Генерация и обработка исключений

public class ExceptionsHandlingDemo {
    public static void main(String[] args) {

        System.out.println("=== Обработка исключений ===\n");

        // 1. ArithmeticException
        System.out.println("1. ArithmeticException (деление на ноль):");
        try {
            int result = 10 / 0;
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("   Ошибка: " + e.getMessage());
        }

        // 2. ArrayIndexOutOfBoundsException
        System.out.println("\n2. ArrayIndexOutOfBoundsException (выход за границы массива):");
        try {
            int[] arr = {1, 2, 3};
            int value = arr[5];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Ошибка: " + e.getMessage());
        }

        // 3. IllegalArgumentException
        System.out.println("\n3. IllegalArgumentException (некорректный аргумент):");
        try {
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("   Ошибка: " + e.getMessage());
        }

        // 4. ClassCastException
        System.out.println("\n4. ClassCastException (некорректное приведение типов):");
        try {
            Object obj = "Это строка";
            Integer num = (Integer) obj;
            System.out.println("Число: " + num);
        } catch (ClassCastException e) {
            System.out.println("   Ошибка: " + e.getMessage());
        }

        // 5. NullPointerException
        System.out.println("\n5. NullPointerException (вызов метода на null):");
        try {
            String str = null;
            int length = str.length();
            System.out.println("Длина: " + length);
        } catch (NullPointerException e) {
            System.out.println("   Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== Программа продолжает работу после обработки исключений ===");
    }

    static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным: " + age);
        }
        System.out.println("Возраст установлен: " + age);
    }
}
