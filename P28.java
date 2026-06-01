//================================================================================//
//Интерфейсы
//================================================================================//
//Задачи 1-2
//================================================================================//

interface Interface28A {

    void methodA();
}

// практика 2 public interface
// доступен отовсюду

public class P28 {

    public static void main(String[] args) {

        Test28 obj = new Test28();

        obj.methodA();
        obj.methodB();
    }
}

interface Interface28B {
    // поля автоматически:
    // public static final
    int VALUE = 100;
    // методы автоматически:
    // public abstract
    void methodB();
}

// класс реализует интерфейсы

class Test28 implements Interface28A, Interface28B {

    @Override
    public void methodA() {
        System.out.println("methodA");
    }
    @Override
    public void methodB() {
        System.out.println("methodB");
    }
}
 

//================================================================================//
//Задачи 3
//================================================================================//


//protected interface нельзя объявить
//на верхнем уровне файла
//protected можно использовать
//только для вложенных интерфейсов

class Outer28 {

    protected interface Protected28 {

        void print();
    }
}


//================================================================================//
//Задачи 4
//================================================================================//

//private interface нельзя объявить
//на верхнем уровне файла
//private интерфейс возможен
//только как вложенный interface

class OuterPrivate28 {

    private interface Private28 {
        void show();
    }
}
