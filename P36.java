//================================================================================//
//Обработка нескольких исключений
//================================================================================//

public class MultiCatchDemo {
    public static void main(String[] args) {

        System.out.println("=== Ситуация 1: несколько исключений обрабатываются одинаково ===\n");

        // Способ 1: Использование multi-catch (Java 7+)
        try {
            // Меняйте значение для генерации разных исключений
            String test = "null"; // "null" - NullPointerException, "array" - ArrayIndexOutOfBoundsException

            if (test.equals("null")) {
                String str = null;
                str.length(); // NullPointerException
            } else if (test.equals("array")) {
                int[] arr = new int[2];
                arr[5] = 10; // ArrayIndexOutOfBoundsException
            }

        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("   Обработка через multi-catch: " + e.getClass().getSimpleName());
            System.out.println("   Сообщение: " + e.getMessage());
        }

        // Способ 2: Использование общего родительского класса
        System.out.println("\n   Альтернативный способ (через родительский класс):");
        try {
            String str = null;
            str.length();
        } catch (RuntimeException e) {  // Общий родитель для многих исключений
            System.out.println("   Обработка через RuntimeException: " + e.getClass().getSimpleName());
        }

        System.out.println("\n=== Ситуация 2: Иерархия исключений Ex1 <|-- Ex2 <|-- Ex3 ===\n");

        // Создаем свои исключения с иерархией
        // Exception (родитель всех checked исключений)
        //   └── Ex1 (базовое)
        //        └── Ex2 (наследник Ex1)
        //             └── Ex3 (наследник Ex2)

        try {
            // Меняйте значение для генерации разных исключений
            int type = 3; // 1 - Ex1, 2 - Ex2, 3 - Ex3

            if (type == 1) {
                throw new Ex1("Исключение Ex1");
            } else if (type == 2) {
                throw new Ex2("Исключение Ex2");
            } else if (type == 3) {
                throw new Ex3("Исключение Ex3");
            }

        } catch (Ex3 e) {
            // Самый специфичный - должен быть первым
            System.out.println("   Перехвачено Ex3: " + e.getMessage());
        } catch (Ex2 e) {
            // Более общий
            System.out.println("   Перехвачено Ex2: " + e.getMessage());
        } catch (Ex1 e) {
            // Самый общий - должен быть последним
            System.out.println("   Перехвачено Ex1: " + e.getMessage());
        }

        // Важное замечание
        System.out.println("\n=== Важное правило ===");
        System.out.println("При обработке исключений с иерархией:");
        System.out.println("- catch для подкласса должен идти ПЕРЕД catch для суперкласса");
        System.out.println("- Иначе код не скомпилируется (недостижимый catch)");
    }
}

// Создание иерархии исключений
class Ex1 extends Exception {
    public Ex1(String message) {
        super(message);
    }
}

class Ex2 extends Ex1 {
    public Ex2(String message) {
        super(message);
    }
}

class Ex3 extends Ex2 {
    public Ex3(String message) {
        super(message);
    }
}
