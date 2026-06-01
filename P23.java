//================================================================================//
//Переопределение методов и полиморфизм
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

    public Child() {
        super();
        System.out.println("Конструктор Child");
    }

    public Child(String parentName) {
        super(parentName);
        System.out.println("Конструктор Child с параметром: " + parentName);
    }

    public Child(String parentName, String childName) {
        this(parentName);
        this.name = childName;
        System.out.println("Конструктор Child с двумя параметрами");
    }

    public void showFields() {
        System.out.println("this.name = " + this.name);
        System.out.println("this.value = " + this.value);
        System.out.println("super.name = " + super.name);
        System.out.println("super.value = " + super.value);
        System.out.println("childValue = " + childValue);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Метод Child: name=" + this.name + ", value=" + this.value);
    }

    @Override
    public void calculate() {
        super.calculate();
        System.out.println("Child calculate: " + (this.value + super.value));
    }

    public void calculate(int multiplier) {
        this.calculate();
        System.out.println("Child calculate с множителем: " + (this.value * multiplier));
    }

    public void passThis() {
        otherMethod(this);
    }

    private void otherMethod(Child obj) {
        System.out.println("Получен объект: " + obj.name);
    }
}

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

        System.out.println("\n=== Правила доступности при наследовании ===");
        System.out.println("\nprivate:");
        System.out.println("  - Доступен только внутри того же класса");
        System.out.println("  - Не наследуется подклассами");
        System.out.println("  - Не доступен в подклассах");

        System.out.println("\ndefault (package-private):");
        System.out.println("  - Доступен внутри того же пакета");
        System.out.println("  - Наследуется только если подкласс в том же пакете");
        System.out.println("  - Не доступен в подклассах из другого пакета");

        System.out.println("\nprotected:");
        System.out.println("  - Доступен внутри того же пакета");
        System.out.println("  - Наследуется всегда, независимо от пакета");
        System.out.println("  - Доступен в подклассах из любого пакета");

        System.out.println("\npublic:");
        System.out.println("  - Доступен везде");
        System.out.println("  - Наследуется всегда");
        System.out.println("  - Доступен в подклассах из любого пакета");

        System.out.println("\n=== Важные правила при наследовании ===");
        System.out.println("1. private члены НЕ наследуются");
        System.out.println("2. default члены наследуются только в том же пакете");
        System.out.println("3. protected члены наследуются всегда");
        System.out.println("4. public члены наследуются всегда");
        System.out.println("5. При переопределении можно расширять доступ, но нельзя сужать");
        System.out.println("6. private методы нельзя переопределить (они не видны)");
    }
}
 
//================================================================================//
//Задача 3
//================================================================================//

class BaseClass {
    public void processData(String data) {
        System.out.println("BaseClass обрабатывает: " + data);
    }

    public void calculate(int value) {
        System.out.println("BaseClass вычисляет: " + value);
    }

    public void save() {
        System.out.println("BaseClass сохраняет данные");
    }

    public void updateInfo(String id) {
        System.out.println("BaseClass.updateInfo: " + id);
    }

    public String getName() {
        return "BaseClass";
    }
}

class DerivedClass extends BaseClass {

    // ОШИБКА 1: Опечатка в имени метода
    // Без @Override этот метод был бы обычным новым методом
    // С @Override компилятор покажет ошибку
    // @Override  // Раскомментировать - будет ошибка компиляции!
    public void processDate(String data) {  // Опечатка: Date вместо Data
        System.out.println("DerivedClass обрабатывает: " + data);
    }

    // ОШИБКА 2: Неправильный тип параметра
    // @Override
    // public void calculate(Integer value) {  // Integer vs int - разные типы
    //     System.out.println("DerivedClass вычисляет: " + value);
    // }

    // ОШИБКА 3: Неправильное количество параметров
    // @Override
    // public void calculate(int value, int extra) {  // Лишний параметр
    //     System.out.println("DerivedClass вычисляет: " + value);
    // }

    // ОШИБКА 4: Несовместимый возвращаемый тип
    // @Override
    // public int save() {  // Ошибка! void нельзя изменить на int
    //     System.out.println("DerivedClass сохраняет");
    //     return 1;
    // }

    // ОШИБКА 5: Более строгий модификатор доступа
    // Родительский метод public, в подклассе нельзя сделать protected или private
    // @Override
    // protected void save() {  // Ошибка! Нельзя сужать доступ (public -> protected)
    //     System.out.println("DerivedClass сохраняет");
    // }

    // ОШИБКА 6: Несовместимый тип возвращаемого значения (не ковариантный)
    // Родитель возвращает String, наследник возвращает Integer
    // @Override
    // public Integer getName() {  // Ошибка! Integer не является подтипом String
    //     return 100;
    // }

    // Правильное переопределение
    @Override
    public void calculate(int value) {
        System.out.println("DerivedClass вычисляет: " + value * 2);
    }
}

// Пример изменения родительского класса
class Version1 {
    public void execute(String command) {
        System.out.println("Version1.execute: " + command);
    }
}

class Version2 extends Version1 {

    // Предположим, что в новой версии API метод execute изменил сигнатуру
    // Если разработчик библиотеки изменил сигнатуру родительского метода,
    // то @Override в наследнике покажет ошибку

    @Override
    public void execute(String command) {
        System.out.println("Version2.execute: " + command.toUpperCase());
    }
}

public class OverrideErrorDetectionDemo {
    public static void main(String[] args) {

        System.out.println("========== Задача 3: @Override помогает найти ошибку ==========\n");

        System.out.println("Аннотация @Override заставляет компилятор проверить,");
        System.out.println("что метод действительно переопределяет метод суперкласса.\n");

        System.out.println("Какие ошибки обнаруживает @Override:\n");

        System.out.println("1. Опечатка в имени метода:");
        System.out.println("   Было: processData(String)");
        System.out.println("   Написали: processDate(String)");
        System.out.println("   Результат: метод не переопределяет родительский, а создает новый");
        System.out.println("   С @Override: ошибка компиляции 'method does not override or implement a method'\n");

        System.out.println("2. Неправильные типы параметров:");
        System.out.println("   Было: calculate(int)");
        System.out.println("   Написали: calculate(Integer)");
        System.out.println("   Результат: перегрузка, а не переопределение");
        System.out.println("   С @Override: ошибка компиляции\n");

        System.out.println("3. Неправильное количество параметров:");
        System.out.println("   Было: calculate(int)");
        System.out.println("   Написали: calculate(int, int)");
        System.out.println("   Результат: перегрузка, а не переопределение");
        System.out.println("   С @Override: ошибка компиляции\n");

        System.out.println("4. Несовместимый возвращаемый тип:");
        System.out.println("   Было: void save()");
        System.out.println("   Написали: int save()");
        System.out.println("   Результат: ошибка компиляции, даже без @Override");
        System.out.println("   С @Override: ошибка компиляции (но более явная)\n");

        System.out.println("5. Более строгий модификатор доступа:");
        System.out.println("   Было: public void save()");
        System.out.println("   Написали: protected void save()");
        System.out.println("   Результат: ошибка компиляции, даже без @Override");
        System.out.println("   С @Override: ошибка компиляции\n");

        System.out.println("6. Рефакторинг родительского класса:");
        System.out.println("   Разработчик библиотеки переименовал метод в родителе");
        System.out.println("   Например: execute() -> run()");
        System.out.println("   Без @Override: метод в наследнике остается, но не вызывается полиморфно");
        System.out.println("   С @Override: ошибка компиляции, сразу видно проблему\n");

        System.out.println("=== Практический пример ===");

        DerivedClass derived = new DerivedClass();

        // Этот вызов работает корректно, так как метод правильно переопределен
        System.out.println("Вызов правильно переопределенного метода:");
        derived.calculate(10);

        System.out.println("\nВызов метода с опечаткой (без @Override):");
        derived.processData("Тестовые данные");  // Работает, но вызывает родительский метод

        System.out.println("\n--- Что произойдет, если убрать @Override с ошибочного метода? ---");
        System.out.println("Метод с опечаткой processDate станет новым методом класса DerivedClass");
        System.out.println("При вызове processData будет вызываться родительский метод");
        System.out.println("Ошибка останется незамеченной до выполнения программы\n");

        System.out.println("=== Вывод ===");
        System.out.println("- Всегда используйте @Override при переопределении методов");
        System.out.println("- @Override помогает обнаружить ошибки на этапе компиляции");
        System.out.println("- @Override делает код более читаемым и понятным");
        System.out.println("- IDE подсвечивает ошибки переопределения при использовании @Override");
    }
}
