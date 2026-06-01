//================================================================================//
//Использование super и this
//================================================================================//
 
 //================================================================================//
// Задача 1 super
//================================================================================//

class Parent22 {

    int value = 100;

    Parent22() {
        System.out.println("конструктор Parent22");
    }

    void method() {
        System.out.println("метод Parent22");
    }
}

class Child22 extends Parent22 {

    int value = 200;

    Child22() {

        // вызов конструктора суперкласса
        super();

        System.out.println("конструктор Child22");
    }

    void print() {

        // доступ к полю суперкласса
        System.out.println(super.value);

        // доступ к методу суперкласса
        super.method();
    }
}

//================================================================================//
// Задача 2 super в наследовании
//================================================================================//

class A22 {

    int a = 10;

    void method() {
        System.out.println("method из A22");
    }
}

class B22 extends A22 {
}

class C22 extends B22 {

    void methodC() {

        // super.a найдёт поле в A22
        int value = super.a;

        System.out.println(value);

        // super.method() вызовет метод из A22
        super.method();
    }
}

//================================================================================//
// Задача 3 this()
//================================================================================//

class D22 {

    int a;
    int b;
    int c;
    int z;

    public D22() {
        z = 1;
    }

    public D22(int a) {

        this();

        this.a = a;
    }

    public D22(int a, int b) {

        this(a);

        this.b = b;
    }

    public D22(int a, int b, int c) {

        this(a, b);

        this.c = c;
    }
}

public class P22 {

    public static void main(String[] args) {

        Child22 child = new Child22();

        child.print();

        C22 obj = new C22();
        obj.methodC();

        D22 d = new D22(1, 2, 3);

        System.out.println(d.a);
        System.out.println(d.b);
        System.out.println(d.c);
        System.out.println(d.z);
    }
}
