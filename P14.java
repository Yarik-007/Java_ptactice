//================================================================================//
//Модификатор final и неизменяемость
//================================================================================//
 
 public class A {
    public final int a;

    // Способ 2: через конструктор
    public A() {
        a = 10;
    }

    // Альтернативный конструктор с параметром
    public A(int value) {
        a = value;
    }
}

// Демонстрация других способов в разных классах:

// Способ 1: инициализация при объявлении
public class B {
    public final int b = 20;
}

// Способ 3: инициализация в блоке инициализации
public class C {
    public final int c;

    {
        c = 30;
    }
}

// Пример использования
public class Main {
    public static void main(String[] args) {
        A obj1 = new A();        // a = 10
        A obj2 = new A(99);      // a = 99
        B obj3 = new B();        // b = 20
        C obj4 = new C();        // c = 30

        System.out.println(obj1.a);  // 10
        System.out.println(obj2.a);  // 99
        System.out.println(obj3.b);  // 20
        System.out.println(obj4.c);  // 30

        // obj1.a = 15;  // Ошибка! Нельзя изменить final-переменную
    }
}
