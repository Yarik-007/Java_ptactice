//================================================================================//
//Аннотации
//================================================================================//

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// пользовательская аннотация

@Target(ElementType.TYPE)
@interface BaseAction29 {
    int level();
}

// использование аннотации

@BaseAction29(level = 2)
class Base29 {

    public void doAction() {
        Class<?> clazz = Base29.class;
        BaseAction29 action =
                clazz.getAnnotation(BaseAction29.class);
        System.out.println(action.level());
    }
}

// практика 1 стандартные аннотации

class Parent29 {
    void print() {
        System.out.println("parent");
    }
}

class Child29 extends Parent29 {
    // проверка переопределения метода
    @Override
    void print() {
        System.out.println("child");
    }
}

class OldClass29 {

    // метод устарел
    @Deprecated
    void oldMethod() {
        System.out.println("old method");
    }
}

public class P29 {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // @Override
        Child29 child = new Child29();
        child.print();
        // @Deprecated
        OldClass29 old = new OldClass29();
        old.oldMethod();
        // @SuppressWarnings
        // отключает предупреждение компилятора

        // пользовательская аннотация
        Base29 base = new Base29();
        base.doAction();
    }
}
