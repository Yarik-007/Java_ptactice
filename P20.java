//================================================================================//
//Наследование
//================================================================================//
//Задача 1
//================================================================================//

class Parent {
    protected String name = "Родитель";
    protected int value = 100;

    public Parent() {
        System.out.println("Конструктор Parent");
    }

    public Parent(String name) {
        this.name = name;
        System.out.println("Конструктор Parent с параметром: " + name);
    }

    public void display() {
        System.out.println("Метод Parent: name=" + name + ", value=" + value);
    }

    public void calculate() {
        System.out.println("Parent calculate: " + value);
    }
}

class Child extends Parent {
    private String name = "Ребенок";
    private int value = 200;
    private int childValue = 500;

    // Конструктор 1: неявный вызов super()
    public Child() {
        super(); // Вызов конструктора родителя (можно не писать - вызывается автоматически)
        System.out.println("Конструктор Child");
    }

    // Конструктор 2: вызов super с параметром
    public Child(String parentName) {
        super(parentName); // Вызов конструктора Parent(String name)
        System.out.println("Конструктор Child с параметром: " + parentName);
    }

    // Конструктор 3: вызов this()
    public Child(String parentName, String childName) {
        this(parentName); // Вызов конструктора Child(String)
        this.name = childName;
        System.out.println("Конструктор Child с двумя параметрами");
    }

    // Пример использования this и super в методах
    public void showFields() {
        // this - обращение к полям текущего класса
        System.out.println("this.name = " + this.name);     // "Ребенок"
        System.out.println("this.value = " + this.value);   // 200

        // super - обращение к полям родительского класса
        System.out.println("super.name = " + super.name);   // "Родитель"
        System.out.println("super.value = " + super.value); // 100

        // Если нет конфликта имен, можно опустить this/super
        System.out.println("childValue = " + childValue);   // 500
    }

    // Переопределение метода с использованием super
    @Override
    public void display() {
        // Вызов метода родителя
        super.display(); // Выведет: Метод Parent: name=Родитель, value=100

        // Дополнительная логика
        System.out.println("Метод Child: name=" + this.name + ", value=" + this.value);
    }

    @Override
    public void calculate() {
        // Использование super для вызова метода родителя
        super.calculate(); // Вызов Parent calculate

        // Своя реализация
        System.out.println("Child calculate: " + (this.value + super.value));
    }

    // Перегрузка метода с использованием this
    public void calculate(int multiplier) {
        this.calculate(); // Вызов метода calculate() текущего класса
        System.out.println("Child calculate с множителем: " + (this.value * multiplier));
    }

    // Пример передачи this как параметра
    public void passThis() {
        otherMethod(this); // Передаем текущий объект
    }

    private void otherMethod(Child obj) {
        System.out.println("Получен объект: " + obj.name);
    }
}

// Пример с иерархией из трех уровней
class GrandParent {
    protected String value = "GrandParent";

    GrandParent() {
        System.out.println("GrandParent constructor");
    }

    void show() {
        System.out.println("GrandParent: " + value);
    }
}

class Parent2 extends GrandParent {
    protected String value = "Parent2";

    Parent2() {
        super(); // Вызов конструктора GrandParent
        System.out.println("Parent2 constructor");
    }

    @Override
    void show() {
        super.show(); // Вызов GrandParent.show()
        System.out.println("Parent2: " + this.value);
    }
}

class Child2 extends Parent2 {
    private String value = "Child2";

    Child2() {
        super(); // Вызов конструктора Parent2
        System.out.println("Child2 constructor");
    }

    @Override
    void show() {
        super.show(); // Вызов Parent2.show() (который вызывает GrandParent.show())
        System.out.println("Child2: " + this.value);
    }

    void demonstrateSuperChain() {
        System.out.println("\n=== Цепочка super ===");
        System.out.println("super.value (Parent2): " + super.value);
        // Нельзя напрямую обратиться к GrandParent.value через super.super
        // Нужно использовать методы родителя
        super.show(); // Через метод родителя, который покажет и GrandParent
    }
}

// Демонстрация
public class ThisSuperDemo {
    public static void main(String[] args) {
        System.out.println("=== Создание Child() ===");
        Child child1 = new Child();
        child1.showFields();
        child1.display();

        System.out.println("\n=== Создание Child(\"Новый родитель\") ===");
        Child child2 = new Child("Новый родитель");
        child2.display();

        System.out.println("\n=== Создание Child(\"Род\", \"Реб\") ===");
        Child child3 = new Child("Род", "Реб");
        child3.display();

        System.out.println("\n=== Трехуровневая иерархия ===");
        Child2 child2Obj = new Child2();
        child2Obj.show();
        child2Obj.demonstrateSuperChain();
    }
}


//================================================================================//
//Задача 2
//================================================================================//

class A {
    int a1;           // default (package-private)
    public int a2;    // public
    protected int a3; // protected
    private int a4;   // private

    void method1() {
        System.out.println("A.method1() - default");
        a4 = 10;
    }

    public void method2() {
        System.out.println("A.method2() - public");
    }

    protected void method3() {
        System.out.println("A.method3() - protected");
    }

    private void method4() {
        System.out.println("A.method4() - private");
    }

    public void accessPrivate() {
        method4();
    }
}

class B extends A {
    void testAccessInB() {
        a1 = 1;     // default - доступен в том же пакете
        a2 = 2;     // public - доступен всегда
        a3 = 3;     // protected - доступен в подклассе
        // a4 = 4;  // private - НЕ доступен даже в подклассе

        method1();  // default - доступен
        method2();  // public - доступен
        method3();  // protected - доступен
        // method4(); // private - НЕ доступен
    }

    @Override
    public void method1() {  // default -> public (расширение доступа)
        System.out.println("B.method1() - переопределен с public");
        super.method1();
    }

    @Override
    public void method2() {
        System.out.println("B.method2() - переопределен");
    }

    @Override
    public void method3() {  // protected -> public (расширение)
        System.out.println("B.method3() - переопределен с public");
    }

    // Нельзя переопределить private метод
    // @Override private void method4() { }

    // Нельзя сузить доступ при переопределении
    // @Override protected void method2() { }
}

class C extends B {
    void testAccessInC() {
        a1 = 10;    // default - если C в том же пакете
        a2 = 20;    // public
        a3 = 30;    // protected
        // a4 = 40; // private - никогда не доступен

        method1();  // public
        method2();  // public
        method3();  // public
    }

    @Override
    public void method1() {
        System.out.println("C.method1() - переопределен");
        super.method1();
    }
}

public class AccessModifiersInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация доступа ===\n");

        A objA = new A();
        B objB = new B();
        C objC = new C();

        System.out.println("--- Доступ к полям из внешнего класса (тот же пакет) ---");
        System.out.println("objA.a1 = " + objA.a1);
        System.out.println("objA.a2 = " + objA.a2);
        System.out.println("objA.a3 = " + objA.a3);

        System.out.println("\n--- Вызов методов из внешнего класса ---");
        objA.method1();
        objA.method2();
        objA.method3();

        System.out.println("\n--- Демонстрация переопределения ---");
        System.out.println("Вызов method1() через объект C:");
        objC.method1();

        System.out.println("\n=== Сводная таблица доступности ===");
        printAccessibilityTable();
    }

    static void printAccessibilityTable() {
        System.out.println("\nМодификатор | Тот же класс | Тот же пакет | Подкласс(друг.пакет) | Любой класс");
        System.out.println("------------|--------------|--------------|---------------------|-------------");
        System.out.println("private     |      да      |      нет     |         нет         |     нет");
        System.out.println("default     |      да      |      да      |         нет         |     нет");
        System.out.println("protected   |      да      |      да      |         да          |     нет");
        System.out.println("public      |      да      |      да      |         да          |     да");

        System.out.println("\nВажные правила при наследовании:");
        System.out.println("1. private члены НЕ наследуются");
        System.out.println("2. default члены наследуются только в том же пакете");
        System.out.println("3. protected члены наследуются всегда");
        System.out.println("4. public члены наследуются всегда");
        System.out.println("5. При переопределении можно расширять доступ, но нельзя сужать");
        System.out.println("6. private методы нельзя переопределить (они не видны)");
    }
}
