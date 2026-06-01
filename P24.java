// практика 24 статические методы и полиморфизм

class A24 {
    public static void method() {
        System.out.println("method из A24");
    }
}

class B24 extends A24 {
    // static методы не переопределяются
    // а скрываются
    public static void method() {
        System.out.println("method из B24");
    }
}

public class P24 {

    public static void main(String[] args) {
        A24 a = new A24();
        B24 b = new B24();
        A24 obj = new B24();
        a.method();
        b.method();
        // вызовется method из A24
        obj.method();
        /*динамический полиморфизм работает
        только для обычных методов объекта
        static методы принадлежат классу,
        а не объекту
        поэтому выбор метода происходит
        на этапе компиляции по типу ссылки,
        а не во время выполнения*/
    }
}
