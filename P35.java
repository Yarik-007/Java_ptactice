//================================================================================//
//Способы обработки исключений
//================================================================================//

public class ExceptionHandlingDemo {
    public static void main(String[] args) {

        System.out.println("=== Пример: одно исключение перехвачено, другое приводит к остановке ===\n");

        // Пример 1: ArithmeticException будет перехвачена
        System.out.println("1. Перехваченное исключение (ArithmeticException):");
        try {
            int result = 10 / 0;  // Генерация ArithmeticException
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("   Перехвачено: " + e.getMessage());
        }
        System.out.println("   Программа продолжает работу после перехвата\n");

        // Пример 2: NullPointerException приведет к аварийной остановке
        System.out.println("2. Неперехваченное исключение (NullPointerException):");
        String str = null;
        int length = str.length();  // Генерация NullPointerException (программа упадет)
        System.out.println("Длина строки: " + length);  // Эта строка не выполнится

        System.out.println("Эта строка никогда не выведется");
    }
}
