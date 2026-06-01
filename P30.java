//================================================================================//
// Функциональные интерфейсы
//================================================================================//
// Задача 1
//================================================================================//

// Интерфейс с неабстрактным (default) и статическим методами

interface Greeting {

    // Абстрактный метод (должен быть реализован в классе)
    void sayHello();

    // Неабстрактный метод (default) - имеет реализацию
    default void sayGoodbye() {
        System.out.println("До свидания! (из default метода интерфейса)");
    }

    // Статический метод - принадлежит интерфейсу
    static void sayWelcome() {
        System.out.println("Добро пожаловать! (из статического метода интерфейса)");
    }
}

// Класс, реализующий интерфейс
class RussianPerson implements Greeting {

    @Override
    public void sayHello() {
        System.out.println("Привет! (реализация в классе)");
    }

    // Можно переопределить default метод (но не обязательно)
    @Override
    public void sayGoodbye() {
        System.out.println("Пока! (переопределенный default метод)");
    }
}

// Демонстрация
public class InterfaceMethodsDemo {
    public static void main(String[] args) {

        System.out.println("=== Способы вызова методов интерфейса ===\n");

        // Способ 1: Вызов статического метода интерфейса
        System.out.println("1. Вызов статического метода:");
        Greeting.sayWelcome();

        // Способ 2: Вызов через объект класса-реализации
        System.out.println("\n2. Вызов через объект класса:");
        RussianPerson person = new RussianPerson();
        person.sayHello();      // абстрактный метод
        person.sayGoodbye();    // default метод (переопределен)

        // Способ 3: Вызов через ссылку на интерфейс
        System.out.println("\n3. Вызов через ссылку на интерфейс:");
        Greeting greeting = new RussianPerson();
        greeting.sayHello();
        greeting.sayGoodbye();

        // Нельзя вызвать статический метод через объект
        // person.sayWelcome(); // Ошибка!
    }
}

 
//================================================================================//
// Задача 2
//================================================================================//

// Конфликт одинаковых default методов в двух интерфейсах

interface InterfaceA {
    default void print() {
        System.out.println("InterfaceA: print()");
    }

    default void show() {
        System.out.println("InterfaceA: show()");
    }
}

interface InterfaceB {
    default void print() {
        System.out.println("InterfaceB: print()");
    }

    default void display() {
        System.out.println("InterfaceB: display()");
    }
}

// Решение 1: Переопределить конфликтующий метод в классе
class MyClass implements InterfaceA, InterfaceB {

    // Обязательно переопределить конфликтующий метод print()
    @Override
    public void print() {
        System.out.println("MyClass: переопределенный print()");

        // Можно выбрать реализацию любого интерфейса через super
        // InterfaceA.super.print();  // вызов версии из InterfaceA
        // InterfaceB.super.print();  // вызов версии из InterfaceB
    }

    // Методы show() и display() не конфликтуют, можно не переопределять
}

// Решение 2: Выбрать конкретную реализацию через super
class MyClassWithChoice implements InterfaceA, InterfaceB {

    @Override
    public void print() {
        // Выбираем реализацию из InterfaceA
        InterfaceA.super.print();
    }
}

// Решение 3: Полностью новая реализация
class MyClassNewImpl implements InterfaceA, InterfaceB {

    @Override
    public void print() {
        System.out.println("Совсем новая реализация");
    }
}

// Демонстрация решения конфликта
public class MultipleInheritanceDemo {
    public static void main(String[] args) {

        System.out.println("=== Конфликт default методов в интерфейсах ===\n");

        MyClass obj = new MyClass();
        obj.print();      // вызывает переопределенный метод
        obj.show();       // из InterfaceA (нет конфликта)
        obj.display();    // из InterfaceB (нет конфликта)

        System.out.println("\n=== Что произойдет без переопределения? ===");
        System.out.println("Ошибка компиляции: класс наследует несвязанные default методы");
        System.out.println("'MyClass inherits unrelated defaults for print()'");

        System.out.println("\n=== Способы решения конфликта ===");
        System.out.println("1. Переопределить конфликтующий метод в классе");
        System.out.println("2. Выбрать реализацию через InterfaceName.super.метод()");
        System.out.println("3. Создать полностью новую реализацию");
    }
}
