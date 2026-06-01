
//================================================================================//
//Классы и методы final
//================================================================================//

public class P21 {

    //1 final-метод нельзя переопределить
    class Parent {
        public void normalMethod() {
            System.out.println("Обычный метод Parent");
        }

        public final void finalMethod() {
            System.out.println("final-метод Parent - нельзя переопределить");
        }
    }

    class Child extends Parent {
        // OK - обычный метод можно переопределить
        @Override
        public void normalMethod() {
            System.out.println("Переопределенный метод Child");
        }

        // Нельзя переопределить final-метод
        // @Override
        // public void finalMethod() {
        //     System.out.println("Попытка переопределить final-метод");
        // }
    }

    //2 final-класс нельзя расширить
    final class FinalClass {
        public void someMethod() {
            System.out.println("Метод final-класса");
        }
    }

    //Нельзя наследоваться от final-класса
    /*
    class ExtendedClass extends FinalClass {
        // Ошибка компиляции: cannot inherit from final FinalClass
    }
    */

// Обычный класс - можно наследоваться
class NormalClass {
    public void someMethod() {
        System.out.println("Метод обычного класса");
    }
}

class ExtendedNormalClass extends NormalClass {
    @Override
    public void someMethod() {
        System.out.println("Переопределенный метод");
    }
}

public static void main(String[] args) {
    P21 example = new P21();

    // Демонстрация работы final-метода
    Child child = example.new Child();
    child.normalMethod();   // Переопределенный метод Child
    child.finalMethod();    // final-метод Parent - нельзя переопределить

    // Демонстрация final-класса
    FinalClass finalObj = example.new FinalClass();
    finalObj.someMethod();  // Метод final-класса
}
}/* ВЫВОД:
Переопределенный метод Child
final-метод Parent - нельзя переопределить
Метод final-класса
*/
