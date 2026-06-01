//================================================================================//
//Вложенные (nested) классы
//================================================================================//

interface Vehicle {

    // Вложенный класс внутри интерфейса
    class Engine {
        private String type;

        public Engine(String type) {
            this.type = type;
        }

        public void start() {
            System.out.println("Двигатель " + type + " запущен");
        }

        public void stop() {
            System.out.println("Двигатель " + type + " остановлен");
        }
    }

    // Метод интерфейса
    void drive();
}

// Реализация интерфейса
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Машина едет");
    }
}

// Другой пример - интерфейс с вложенным классом-помощником
interface MathOperations {

    // Вложенный класс-утилита
    class Helper {
        public static int square(int x) {
            return x * x;
        }

        public static int cube(int x) {
            return x * x * x;
        }

        public static boolean isEven(int x) {
            return x % 2 == 0;
        }
    }

    int calculate(int a, int b);
}

// Демонстрация
public class NestedClassInInterfaceDemo {
    public static void main(String[] args) {

        System.out.println("=== Способ 1: Создание объекта вложенного класса ===");
        // Создаем объект вложенного класса через интерфейс
        Vehicle.Engine engine = new Vehicle.Engine("V8");
        engine.start();
        engine.stop();

        System.out.println("\n=== Способ 2: Вызов статических методов ===");
        // Вызов статических методов вложенного класса
        int num = 5;
        System.out.println("Квадрат " + num + ": " + MathOperations.Helper.square(num));
        System.out.println("Куб " + num + ": " + MathOperations.Helper.cube(num));
        System.out.println("Число " + num + " четное? " + MathOperations.Helper.isEven(num));

        System.out.println("\n=== Способ 3: Использование с реализацией интерфейса ===");
        // Обычное использование интерфейса
        Car car = new Car();
        car.drive();

        // Можно создать двигатель внутри машины
        Vehicle.Engine carEngine = new Vehicle.Engine("Electric");
        carEngine.start();
    }
}
